package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImportantMsgEntryConfig
{
  private HashMap<Integer, ImportantMsgEntryConfig.EntryConfig> a = new HashMap();
  
  public ImportantMsgEntryConfig()
  {
    this.a.put(Integer.valueOf(1), new ImportantMsgEntryConfig.EntryConfig("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j13h02.png", 1L, 0, ""));
    this.a.put(Integer.valueOf(2), new ImportantMsgEntryConfig.EntryConfig("https://pub.idqqimg.com/pc/misc/files/20200324/5a1434be69aa5a61dca2e97db65cf50b.png", 1101236949L, 0, ""));
    this.a.put(Integer.valueOf(3), new ImportantMsgEntryConfig.EntryConfig("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j17n0g.png", 101786420L, 0, ""));
    this.a.put(Integer.valueOf(4), new ImportantMsgEntryConfig.EntryConfig("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j16hii.png", 1104445552L, 0, ""));
    this.a.put(Integer.valueOf(5), new ImportantMsgEntryConfig.EntryConfig("https://pub.idqqimg.com/pc/misc/files/20180702/b836834dfbe493017b8767425c0d23e8jj3xilnn.png", 101458937L, 0, ""));
    this.a.put(Integer.valueOf(6), new ImportantMsgEntryConfig.EntryConfig("https://pub.idqqimg.com/pc/misc/files/20190620/da7e017785e02546d81a93f6885b7c3fjx4cf6io.png", 1108961705L, 0, ""));
  }
  
  public static ImportantMsgEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    ImportantMsgEntryConfig localImportantMsgEntryConfig = new ImportantMsgEntryConfig();
    int i = 0;
    while (i < paramArrayOfQConfItem.length)
    {
      Object localObject = paramArrayOfQConfItem[i].b;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          HashMap localHashMap = new HashMap();
          localObject = new JSONObject((String)localObject).optJSONArray("configs");
          if (localObject != null)
          {
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              int k = -1;
              ImportantMsgEntryConfig.EntryConfig localEntryConfig = new ImportantMsgEntryConfig.EntryConfig();
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
              if (localJSONObject != null)
              {
                k = localJSONObject.optInt("t");
                localEntryConfig.a = localJSONObject.optString("url");
                localEntryConfig.b = localJSONObject.optLong("id");
                localEntryConfig.c = localJSONObject.optInt("titletype");
                localEntryConfig.d = localJSONObject.optString("deftitle");
              }
              localHashMap.put(Integer.valueOf(k), localEntryConfig);
              j += 1;
            }
          }
          localImportantMsgEntryConfig.a(localHashMap);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ImportantMsgEntryConfig", 2, localImportantMsgEntryConfig.toString());
    }
    return localImportantMsgEntryConfig;
  }
  
  public ImportantMsgEntryConfig.EntryConfig a(int paramInt)
  {
    return (ImportantMsgEntryConfig.EntryConfig)this.a.get(Integer.valueOf(paramInt));
  }
  
  protected void a(HashMap<Integer, ImportantMsgEntryConfig.EntryConfig> paramHashMap)
  {
    if (paramHashMap != null)
    {
      this.a.clear();
      this.a.putAll(paramHashMap);
    }
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgEntryConfig
 * JD-Core Version:    0.7.0.1
 */