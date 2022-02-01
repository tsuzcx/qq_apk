package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IVasLog;
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
  public static final String SEQ_CONFIG_PATH;
  private static final String TAG = "VasUpdate_SeqConfig";
  public String mAppVer;
  public int mPollTime;
  public ArrayList<PreloadItem> mPreloadList;
  public int mPreloadVer;
  public long mSeq;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VasUpdateWrapper.getCommonManager().c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("seq_v2.cfg");
    SEQ_CONFIG_PATH = localStringBuilder.toString();
  }
  
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
    Object localObject1 = new SeqConfigEntity();
    Object localObject2 = new File(SEQ_CONFIG_PATH);
    if (!((File)localObject2).exists()) {
      return localObject1;
    }
    localObject1 = FileUtil.readFileContent((File)localObject2);
    localObject2 = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSeqConfig content = ");
    localStringBuilder.append((String)localObject1);
    ((IVasLog)localObject2).c("VasUpdate_SeqConfig", localStringBuilder.toString());
    return parseSeqJson((String)localObject1);
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
      VasUpdateWrapper.getLog().a("VasUpdate_SeqConfig", "parseSeqJson exception", paramString);
    }
    return localSeqConfigEntity;
  }
  
  public static void saveSeqConfig(SeqConfigEntity paramSeqConfigEntity)
  {
    if (paramSeqConfigEntity == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("seq", paramSeqConfigEntity.mSeq);
      localJSONObject.put("appver", paramSeqConfigEntity.mAppVer);
      localJSONObject.put("plver", paramSeqConfigEntity.mPreloadVer);
      localJSONObject.put("mPreloadList", convertPreloadListToJson(paramSeqConfigEntity.mPreloadList));
    }
    catch (JSONException paramSeqConfigEntity)
    {
      paramSeqConfigEntity.printStackTrace();
    }
    boolean bool = FileUtil.writeFileContent(SEQ_CONFIG_PATH, localJSONObject.toString());
    if (VasUpdateWrapper.getLog().a())
    {
      paramSeqConfigEntity = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSeqConfig result = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" value = \n");
      localStringBuilder.append(localJSONObject.toString());
      paramSeqConfigEntity.b("VasUpdate_SeqConfig", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.SeqConfigEntity
 * JD-Core Version:    0.7.0.1
 */