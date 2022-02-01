package com.tencent.tgpa.vendorpd.a;

import android.util.Log;
import com.tencent.tgpa.vendorpd.CombinationInfo;
import com.tencent.tgpa.vendorpd.GamePredownloader.CombinationError;
import com.tencent.tgpa.vendorpd.b.c;
import com.tencent.tgpa.vendorpd.b.f;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public long a;
  public long b = 0L;
  public long c = 0L;
  private long d = 0L;
  private final CombinationInfo e;
  
  public a(CombinationInfo paramCombinationInfo)
  {
    this.jdField_a_of_type_Long = 0L;
    this.e = paramCombinationInfo;
  }
  
  private GamePredownloader.CombinationError a(String paramString1, String paramString2, int paramInt, a.a parama, ArrayList<a.c> paramArrayList)
  {
    long l = parama.jdField_a_of_type_Long;
    int i = parama.jdField_a_of_type_Int;
    parama = parama.jdField_a_of_type_JavaLangString;
    if ((paramInt != 0) && (paramInt != 1))
    {
      f.a("current server forbid to combine apk. status: %d", new Object[] { Integer.valueOf(paramInt) });
      return GamePredownloader.CombinationError.ServerForbidCombineApk;
    }
    try
    {
      byte[] arrayOfByte1 = c.a(parama);
      if (arrayOfByte1.length != i)
      {
        f.b("cloud channel tag's content size is not matched, ple check it.");
        paramString1 = GamePredownloader.CombinationError.CloudChannelTagSizeNotMatch;
        return paramString1;
      }
      byte[] arrayOfByte2 = a(l, i, paramString2);
      if (arrayOfByte2 == null) {
        return GamePredownloader.CombinationError.ReadPredownloadFileException;
      }
      if (paramInt == 0)
      {
        f.a("local tag: %s, cloud tag: %s", new Object[] { String.valueOf(c.a(arrayOfByte2)), parama });
        if (a(arrayOfByte2, arrayOfByte1))
        {
          if (!new a.b(paramString2, paramArrayList).a())
          {
            f.b("cloud operation do failed, ple check it.");
            return GamePredownloader.CombinationError.OperationExecuteFailed;
          }
          if (!a(paramString1, paramString2)) {
            return GamePredownloader.CombinationError.LocalFileMd5IsNotMatched;
          }
          return GamePredownloader.CombinationError.Success;
        }
        f.b("you can't combine other channels' predownload file.");
        return GamePredownloader.CombinationError.ServerForbidCombineApkOverChannels;
      }
      if (paramInt == 1)
      {
        if (!new a.b(paramString2, paramArrayList).a()) {
          return GamePredownloader.CombinationError.OperationExecuteFailed;
        }
        if (!a(paramString1, paramString2)) {
          return GamePredownloader.CombinationError.LocalFileMd5IsNotMatched;
        }
        return GamePredownloader.CombinationError.Success;
      }
      return GamePredownloader.CombinationError.ServerForbidCombineApk;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      Log.e("TGPA", "cloud channel tag's content decrypt failed. ");
    }
    return GamePredownloader.CombinationError.ContentDecryptException;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      f.b("combine apk cdnMD5 is null, do not need check.");
      return true;
    }
    long l = System.currentTimeMillis();
    paramString2 = c.a(new File(paramString2));
    this.c = (System.currentTimeMillis() - l);
    if ((paramString2 != null) && (paramString2.equals(paramString1))) {
      return true;
    }
    f.b("combine apk failed, md5 is not matched. md5: %s", new Object[] { paramString2 });
    return false;
  }
  
  private boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (!Arrays.equals(paramArrayOfByte1, paramArrayOfByte2))
      {
        Log.e("TGPA", "predownload file's channel tag is not matched in cloud config.");
        return false;
      }
      return true;
    }
    return false;
  }
  
  private byte[] a(long paramLong, int paramInt, String paramString)
  {
    try
    {
      paramString = new RandomAccessFile(new File(paramString), "rw");
      paramString.seek(paramString.length() - paramLong);
      byte[] arrayOfByte = new byte[paramInt];
      paramString.read(arrayOfByte, 0, paramInt);
      paramString.close();
      return arrayOfByte;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      Log.e("TGPA", "can not read tgpa channel in predownload file content.");
    }
    return null;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    boolean bool3 = paramJSONObject.has("channel_tag");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramJSONObject = paramJSONObject.optJSONObject("channel_tag");
      bool1 = bool2;
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (paramJSONObject.has("offset"))
        {
          bool1 = bool2;
          if (paramJSONObject.has("size"))
          {
            bool1 = bool2;
            if (paramJSONObject.has("content")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public GamePredownloader.CombinationError a(String paramString)
  {
    if (paramString == null)
    {
      f.d("combine package request failed, please check. ");
      return GamePredownloader.CombinationError.NetWorkRequestFailed;
    }
    f.a("combine package response: %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("ret"))
      {
        f.b("combine package response parse exception, no ret, please check!");
        return GamePredownloader.CombinationError.JsonParseFailed;
      }
      int i = paramString.getInt("ret");
      if (i != 0)
      {
        f.a("combine package request error, ret is not 0, ret = %d , please check!", new Object[] { Integer.valueOf(i) });
        return GamePredownloader.CombinationError.ServerCheckError;
      }
      if (!paramString.has("data"))
      {
        f.b("combine package request error, no data, please check!");
        return GamePredownloader.CombinationError.JsonParseFailed;
      }
      paramString = GamePredownloader.CombinationError.Success;
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      f.d("combine package response parse to json exception.");
    }
    return GamePredownloader.CombinationError.JsonParseFailed;
  }
  
  public GamePredownloader.CombinationError a(String paramString, CombinationInfo paramCombinationInfo)
  {
    try
    {
      Object localObject = new JSONObject(paramString).getJSONObject("data");
      int i = ((JSONObject)localObject).getInt("status");
      if (!c((JSONObject)localObject))
      {
        f.b("cloud channel tag parse failed, ple check it.");
        return GamePredownloader.CombinationError.CloudChannelTagIsNotCorrect;
      }
      paramString = a((JSONObject)localObject);
      localObject = b((JSONObject)localObject);
      if (localObject == null)
      {
        f.b("cloud operation parse failed, ple check it.");
        return GamePredownloader.CombinationError.JsonParseFailed;
      }
      paramString = a(paramCombinationInfo.cdnMD5, paramCombinationInfo.predownFilePath, i, paramString, (ArrayList)localObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      f.d("combine apk failed because of unkown exception. ple call the developer.");
      return GamePredownloader.CombinationError.CodeRunTimeException;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return GamePredownloader.CombinationError.JsonParseFailed;
  }
  
  public a.a a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("channel_tag");
    return new a.a(paramJSONObject.getLong("offset"), paramJSONObject.getInt("size"), paramJSONObject.getString("content"));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public ArrayList<a.c> b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (!paramJSONObject.has("alter_list")) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONArray("alter_list");
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          if (localJSONObject.optInt("index") != i) {
            return null;
          }
          a.c localc = new a.c(null);
          if (!localc.a(localJSONObject))
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("File operation parse exception, index: ");
            paramJSONObject.append(i);
            f.b(paramJSONObject.toString());
            return null;
          }
          localArrayList.add(localc);
          i += 1;
        }
        else
        {
          return null;
        }
      }
      if (localArrayList.size() <= 0) {
        return null;
      }
      return localArrayList;
    }
    return null;
  }
  
  public void b()
  {
    this.d = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.b = System.currentTimeMillis();
  }
  
  public HashMap<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_name", "CombineApk");
    localHashMap.put("game_name", this.e.gamePackageName);
    localHashMap.put("begin_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("load_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("end_time", String.valueOf(this.d));
    localHashMap.put("md5_time", String.valueOf(this.c));
    localHashMap.put("request_time", String.valueOf(this.b - this.jdField_a_of_type_Long));
    localHashMap.put("run_time", String.valueOf(this.d - this.jdField_a_of_type_Long));
    localHashMap.put("report_time", String.valueOf(System.currentTimeMillis() / 1000L));
    localHashMap.put("predown_file", String.valueOf(this.e.predownFilePath));
    localHashMap.put("file_name", String.valueOf(this.e.cdnUrl));
    localHashMap.put("file_md5", String.valueOf(this.e.cdnMD5));
    localHashMap.put("predownfile_md5", this.e.predownFileMD5);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.a
 * JD-Core Version:    0.7.0.1
 */