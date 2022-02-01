package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SeqConfigEntity
{
  private static final String SEQ_CONFIG = "seq_v2.cfg";
  public static final String SEQ_CONFIG_PATH = VasUpdateWrapper.getCommonManager().getSeqConfigPath() + File.separator + "seq_v2.cfg";
  private static final String TAG = "VasUpdate_SeqConfig";
  public String mAppVer;
  public int mPollTime;
  public ArrayList<PreloadItem> mPreloadList;
  public int mPreloadVer;
  public long mSeq;
  
  public static JSONArray convertPreloadListToJson(ArrayList<PreloadItem> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayList == null) {
      return localJSONArray;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localJSONArray.put(PreloadItem.convertToJson((PreloadItem)paramArrayList.next()));
    }
    return localJSONArray;
  }
  
  public static SeqConfigEntity loadSeqConfig()
  {
    Object localObject = new SeqConfigEntity();
    File localFile = new File(SEQ_CONFIG_PATH);
    if (!localFile.exists()) {
      return localObject;
    }
    localObject = FileUtil.readFileContent(localFile);
    VasUpdateWrapper.getLog().e("VasUpdate_SeqConfig", "loadSeqConfig content = " + (String)localObject);
    return parseSeqJson((String)localObject);
  }
  
  public static SeqConfigEntity parseSeqJson(String paramString)
  {
    SeqConfigEntity localSeqConfigEntity = new SeqConfigEntity();
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return localSeqConfigEntity;
      }
      paramString = new JSONObject(paramString);
      localSeqConfigEntity.mSeq = paramString.optLong("seq");
      localSeqConfigEntity.mAppVer = paramString.optString("appver");
      localSeqConfigEntity.mPreloadVer = paramString.optInt("plver");
      localSeqConfigEntity.mPreloadList = PreloadItem.parsePreloadItemList(paramString.optJSONArray("preloadList"));
      return localSeqConfigEntity;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localSeqConfigEntity;
  }
  
  public static void saveSeqConfig(SeqConfigEntity paramSeqConfigEntity)
  {
    if (paramSeqConfigEntity == null) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("seq", paramSeqConfigEntity.mSeq);
        localJSONObject.put("appver", paramSeqConfigEntity.mAppVer);
        localJSONObject.put("plver", paramSeqConfigEntity.mPreloadVer);
        localJSONObject.put("mPreloadList", convertPreloadListToJson(paramSeqConfigEntity.mPreloadList));
        boolean bool = FileUtil.writeFileContent(SEQ_CONFIG_PATH, localJSONObject.toString());
        if (!VasUpdateWrapper.getLog().isColorLevel()) {
          continue;
        }
        VasUpdateWrapper.getLog().i("VasUpdate_SeqConfig", "saveSeqConfig result = " + bool + " value = \n" + localJSONObject.toString());
        return;
      }
      catch (JSONException paramSeqConfigEntity)
      {
        for (;;)
        {
          paramSeqConfigEntity.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.SeqConfigEntity
 * JD-Core Version:    0.7.0.1
 */