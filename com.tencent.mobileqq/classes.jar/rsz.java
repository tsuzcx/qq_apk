import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rsz
{
  private static final String[] a = { "readinjoy", "kandian" };
  
  public static ArrayList<Intent> a()
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = bmhv.a(pkh.a(), true, false);
    int i = 1;
    while (i <= 2)
    {
      String str = localSharedPreferences.getString("arg_video_local_task1" + i, "");
      if (!TextUtils.isEmpty(str)) {
        a(localSharedPreferences.getString(str, ""), localArrayList);
      }
      i += 1;
    }
    QLog.e("KanDianVideoUploadUtils", 1, "task load over, fail task size:" + localArrayList.size());
    return localArrayList;
  }
  
  public static ArrayList<SocializeFeedsInfo.BiuCommentInfo> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.get("multiBiuStruct").toString());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        String str1 = localJSONObject.get("uin").toString();
        String str2 = localJSONObject.get("comment").toString();
        long l = Long.parseLong(localJSONObject.get("feedid").toString());
        localArrayList.add(new SocializeFeedsInfo.BiuCommentInfo(Long.valueOf(str1), Long.valueOf(l), str2));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("KanDianVideoUploadUtils", 1, "biuJson2List异常:" + paramJSONObject.toString());
    }
  }
  
  public static JSONArray a(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", localBiuCommentInfo.mUin);
        localJSONObject.put("comment", localBiuCommentInfo.mBiuComment);
        localJSONObject.put("feedid", localBiuCommentInfo.mFeedId);
        localJSONObject.put("opType", localBiuCommentInfo.mOpType);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("KanDianVideoUploadUtils", 1, "biuList2JsonArray异常:" + localJSONException.toString());
      }
    }
    return localJSONArray;
  }
  
  public static JSONArray a(List<TagInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TagInfo localTagInfo = (TagInfo)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("tagId", localTagInfo.a());
        localJSONObject.put("tagName", localTagInfo.a());
        localJSONObject.put("tagScore", localTagInfo.a());
        localJSONObject.put("channel", localTagInfo.b());
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("KanDianVideoUploadUtils", 1, "tagList2JsonArray异常:" + localJSONException.toString());
      }
    }
    return localJSONArray;
  }
  
  public static void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("mTaskID");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    QLog.e("KanDianVideoUploadUtils", 1, "saveData2Local taskID:" + str1);
    JSONObject localJSONObject = new JSONObject();
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    Object localObject;
    ArrayList localArrayList;
    String str2;
    try
    {
      localSharedPreferences = bmhv.a(pkh.a(), true, true);
      localEditor = localSharedPreferences.edit();
      localObject = a();
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str2 = ((Intent)((Iterator)localObject).next()).getStringExtra("mTaskID");
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
      }
      localObject = "";
    }
    catch (Exception paramBundle)
    {
      QLog.e("KanDianVideoUploadUtils", 1, str1 + "save data error" + paramBundle.toString());
      paramBundle.printStackTrace();
      return;
    }
    int i = 1;
    for (;;)
    {
      if (i <= 2)
      {
        str2 = localSharedPreferences.getString("arg_video_local_task1" + i, "");
        if (str1.equals(str2)) {
          break;
        }
        if (TextUtils.isEmpty(str2))
        {
          localObject = "arg_video_local_task1" + i;
          break label752;
        }
        if (localArrayList.contains(str2)) {
          break label752;
        }
        localObject = "arg_video_local_task1" + i;
        break label752;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localJSONObject.put("arg_is_from_wang_zhe", paramBundle.getBoolean("arg_is_from_wang_zhe", false));
        localJSONObject.put("is_from_dian_dian", paramBundle.getBoolean("is_from_dian_dian", false));
        localJSONObject.put("is_from_kan_dian", paramBundle.getBoolean("is_from_kan_dian", false));
        localJSONObject.put("arg_video_path", paramBundle.getString("arg_video_path", ""));
        localJSONObject.put("arg_video_cover", paramBundle.getString("arg_video_cover", ""));
        localJSONObject.put("mTaskID", str1);
        localJSONObject.put("commentString", paramBundle.getString("commentString", ""));
        localJSONObject.put("multiBiuStruct", a(paramBundle.getParcelableArrayList("multiBiuStruct")).toString());
        localJSONObject.put("mSelectedTagList", a(paramBundle.getParcelableArrayList("mSelectedTagList")).toString());
        localJSONObject.put("arg_ad_tag", paramBundle.getInt("arg_ad_tag"));
        localJSONObject.put("arg_topic_id", paramBundle.getString("arg_topic_id", ""));
        localJSONObject.put("arg_video_cover_url", paramBundle.getString("arg_video_cover_url", ""));
        localJSONObject.put("arg_video_cover_md5", paramBundle.getString("arg_video_cover_md5", ""));
        localJSONObject.put("arg_video_url", paramBundle.getString("arg_video_url", ""));
        localJSONObject.put("arg_video_title", paramBundle.getString("arg_video_title", ""));
        localJSONObject.put("arg_video_uuid", paramBundle.getString("arg_video_uuid", ""));
        localJSONObject.put("arg_video_duration", paramBundle.getLong("arg_video_duration"));
        localJSONObject.put("arg_video_cover_width", paramBundle.getInt("arg_video_cover_width"));
        localJSONObject.put("arg_video_cover_height", paramBundle.getInt("arg_video_cover_height"));
        localJSONObject.put("arg_video_width", paramBundle.getInt("arg_video_width"));
        localJSONObject.put("arg_video_height", paramBundle.getInt("arg_video_height"));
        localEditor.putString((String)localObject, str1);
        localEditor.putString(str1, localJSONObject.toString());
        localEditor.commit();
        QLog.e("KanDianVideoUploadUtils", 1, str1 + "  saveData2Local success! " + (String)localObject + " data content:" + localJSONObject.toString());
        return;
      }
      QLog.e("KanDianVideoUploadUtils", 1, str1 + "save  data failed!!");
      return;
      label752:
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while (!paramString.exists());
    paramString.delete();
  }
  
  /* Error */
  private static void a(String paramString, ArrayList<Intent> paramArrayList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: new 240	android/content/Intent
    //   14: dup
    //   15: invokespecial 342	android/content/Intent:<init>	()V
    //   18: astore 6
    //   20: new 227	android/os/Bundle
    //   23: dup
    //   24: invokespecial 343	android/os/Bundle:<init>	()V
    //   27: astore 7
    //   29: new 91	org/json/JSONObject
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 344	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: ldc_w 272
    //   42: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 8
    //   47: aload_0
    //   48: ldc 225
    //   50: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 9
    //   55: aload_0
    //   56: ldc_w 256
    //   59: invokevirtual 348	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   62: istore 5
    //   64: aload 9
    //   66: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +614 -> 683
    //   72: aload 8
    //   74: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifeq +450 -> 527
    //   80: goto +603 -> 683
    //   83: aload_0
    //   84: ldc_w 269
    //   87: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 10
    //   92: iload 5
    //   94: ifne +579 -> 673
    //   97: iload 4
    //   99: istore_3
    //   100: aload 10
    //   102: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +21 -> 126
    //   108: new 334	java/io/File
    //   111: dup
    //   112: aload 10
    //   114: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 338	java/io/File:exists	()Z
    //   120: ifne +553 -> 673
    //   123: iload 4
    //   125: istore_3
    //   126: iload_3
    //   127: ifeq +309 -> 436
    //   130: aload 7
    //   132: ldc_w 256
    //   135: iload 5
    //   137: invokevirtual 352	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   140: aload 7
    //   142: ldc_w 265
    //   145: aload_0
    //   146: ldc_w 265
    //   149: invokevirtual 348	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   152: invokevirtual 352	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   155: aload 7
    //   157: ldc_w 267
    //   160: aload_0
    //   161: ldc_w 267
    //   164: invokevirtual 348	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   167: invokevirtual 352	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   170: aload 6
    //   172: ldc_w 269
    //   175: aload 10
    //   177: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   180: pop
    //   181: aload 6
    //   183: ldc_w 272
    //   186: aload 8
    //   188: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   191: pop
    //   192: aload 6
    //   194: ldc 225
    //   196: aload 9
    //   198: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   201: pop
    //   202: aload 6
    //   204: ldc_w 274
    //   207: aload_0
    //   208: ldc_w 274
    //   211: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   217: pop
    //   218: aload 7
    //   220: ldc_w 283
    //   223: aload_0
    //   224: invokestatic 358	rsz:b	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   227: invokevirtual 361	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   230: aload 7
    //   232: ldc 89
    //   234: aload_0
    //   235: invokestatic 363	rsz:a	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   238: invokevirtual 361	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   241: aload 7
    //   243: ldc_w 293
    //   246: aload_0
    //   247: ldc_w 293
    //   250: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokevirtual 366	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload 7
    //   258: ldc_w 287
    //   261: aload_0
    //   262: ldc_w 287
    //   265: invokevirtual 367	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: invokevirtual 371	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   271: aload 7
    //   273: ldc_w 314
    //   276: aload_0
    //   277: ldc_w 314
    //   280: invokevirtual 367	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   283: invokevirtual 371	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   286: aload 7
    //   288: ldc_w 316
    //   291: aload_0
    //   292: ldc_w 316
    //   295: invokevirtual 367	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: invokevirtual 371	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   301: aload 7
    //   303: ldc_w 305
    //   306: aload_0
    //   307: ldc_w 305
    //   310: invokevirtual 372	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   313: invokevirtual 376	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   316: aload 7
    //   318: ldc_w 295
    //   321: aload_0
    //   322: ldc_w 295
    //   325: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   328: invokevirtual 366	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 7
    //   333: ldc_w 297
    //   336: aload_0
    //   337: ldc_w 297
    //   340: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   343: invokevirtual 366	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload 7
    //   348: ldc_w 299
    //   351: aload_0
    //   352: ldc_w 299
    //   355: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   358: invokevirtual 366	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 7
    //   363: ldc_w 301
    //   366: aload_0
    //   367: ldc_w 301
    //   370: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   373: invokevirtual 366	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload 7
    //   378: ldc_w 303
    //   381: aload_0
    //   382: ldc_w 303
    //   385: invokevirtual 345	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: invokevirtual 366	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload 7
    //   393: ldc_w 310
    //   396: aload_0
    //   397: ldc_w 310
    //   400: invokevirtual 367	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   403: invokevirtual 371	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   406: aload 7
    //   408: ldc_w 312
    //   411: aload_0
    //   412: ldc_w 312
    //   415: invokevirtual 367	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   418: invokevirtual 371	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   421: aload 6
    //   423: aload 7
    //   425: invokevirtual 380	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   428: pop
    //   429: aload_1
    //   430: aload 6
    //   432: invokevirtual 134	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   435: pop
    //   436: ldc 68
    //   438: iconst_1
    //   439: new 35	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 382
    //   449: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: iload_3
    //   453: invokevirtual 385	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   456: ldc_w 387
    //   459: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 10
    //   464: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 389
    //   470: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 8
    //   475: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 391
    //   481: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 9
    //   486: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: return
    //   496: astore_0
    //   497: ldc 68
    //   499: iconst_1
    //   500: new 35	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 396
    //   510: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_0
    //   514: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   517: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: return
    //   527: new 334	java/io/File
    //   530: dup
    //   531: aload 8
    //   533: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   536: invokevirtual 338	java/io/File:exists	()Z
    //   539: ifne +139 -> 678
    //   542: iconst_0
    //   543: istore_2
    //   544: goto -461 -> 83
    //   547: astore 11
    //   549: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq -281 -> 271
    //   555: ldc_w 401
    //   558: iconst_2
    //   559: new 35	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 403
    //   569: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 11
    //   574: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   577: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: goto -315 -> 271
    //   589: astore 11
    //   591: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   594: ifeq -278 -> 316
    //   597: ldc_w 401
    //   600: iconst_2
    //   601: new 35	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   608: ldc_w 403
    //   611: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload 11
    //   616: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   619: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: goto -312 -> 316
    //   631: astore 11
    //   633: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -245 -> 391
    //   639: ldc_w 401
    //   642: iconst_2
    //   643: new 35	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 403
    //   653: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 11
    //   658: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   661: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: goto -279 -> 391
    //   673: iload_2
    //   674: istore_3
    //   675: goto -549 -> 126
    //   678: iconst_1
    //   679: istore_2
    //   680: goto -597 -> 83
    //   683: iconst_0
    //   684: istore_2
    //   685: goto -602 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	paramString	String
    //   0	688	1	paramArrayList	ArrayList<Intent>
    //   543	142	2	bool1	boolean
    //   99	576	3	bool2	boolean
    //   1	123	4	bool3	boolean
    //   62	74	5	bool4	boolean
    //   18	413	6	localIntent	Intent
    //   27	397	7	localBundle	Bundle
    //   45	487	8	str1	String
    //   53	432	9	str2	String
    //   90	373	10	str3	String
    //   547	26	11	localException1	Exception
    //   589	26	11	localException2	Exception
    //   631	26	11	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   3	10	496	java/lang/Exception
    //   11	80	496	java/lang/Exception
    //   83	92	496	java/lang/Exception
    //   100	123	496	java/lang/Exception
    //   130	241	496	java/lang/Exception
    //   391	436	496	java/lang/Exception
    //   436	495	496	java/lang/Exception
    //   527	542	496	java/lang/Exception
    //   549	586	496	java/lang/Exception
    //   591	628	496	java/lang/Exception
    //   633	670	496	java/lang/Exception
    //   241	271	547	java/lang/Exception
    //   271	316	589	java/lang/Exception
    //   316	391	631	java/lang/Exception
  }
  
  public static ArrayList<TagInfo> b(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.get("mSelectedTagList").toString());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localArrayList.add(new TagInfo(Long.valueOf(localJSONObject.get("uin").toString()).longValue(), localJSONObject.get("nickName").toString(), Double.parseDouble(localJSONObject.get("tagScore").toString()), Long.parseLong(localJSONObject.get("channel").toString())));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("KanDianVideoUploadUtils", 1, "tagJson2List异常:" + paramJSONObject.toString());
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID", "");
    c(paramBundle);
    paramBundle = bmhv.a(pkh.a(), true, true);
    SharedPreferences.Editor localEditor = paramBundle.edit();
    boolean bool2 = false;
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i <= 2)
      {
        if (str.equals(paramBundle.getString("arg_video_local_task1" + i, "")))
        {
          localEditor.putString("arg_video_local_task1" + i, "");
          localEditor.putString(str, "");
          bool1 = true;
        }
      }
      else
      {
        QLog.e("KanDianVideoUploadUtils", 1, "remove local task:" + str + " state:" + bool1);
        localEditor.commit();
        return;
      }
      i += 1;
    }
  }
  
  private static void c(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("arg_video_cover");
    String str2 = paramBundle.getString("compressPath");
    String str3 = paramBundle.getString("arg_video_path");
    paramBundle = paramBundle.getString("mFakeVidForComposition");
    if (!TextUtils.isEmpty(paramBundle)) {
      new oxj().a(paramBundle);
    }
    a(str1);
    a(str2);
    a(str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsz
 * JD-Core Version:    0.7.0.1
 */