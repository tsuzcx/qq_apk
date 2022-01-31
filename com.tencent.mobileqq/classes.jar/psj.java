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

public class psj
{
  private static final String[] a = { "readinjoy", "kandian" };
  
  public static ArrayList<Intent> a()
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = bgmq.a(obz.a(), true, false);
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
        localJSONObject.put("uin", localBiuCommentInfo.jdField_a_of_type_JavaLangLong);
        localJSONObject.put("comment", localBiuCommentInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("feedid", localBiuCommentInfo.b);
        localJSONObject.put("opType", localBiuCommentInfo.c);
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
      localSharedPreferences = bgmq.a(obz.a(), true, true);
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
          break label750;
        }
        if (localArrayList.contains(str2)) {
          break label750;
        }
        localObject = "arg_video_local_task1" + i;
        break label750;
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
      label750:
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
    //   11: new 237	android/content/Intent
    //   14: dup
    //   15: invokespecial 339	android/content/Intent:<init>	()V
    //   18: astore 6
    //   20: new 224	android/os/Bundle
    //   23: dup
    //   24: invokespecial 340	android/os/Bundle:<init>	()V
    //   27: astore 7
    //   29: new 91	org/json/JSONObject
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 341	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: ldc_w 269
    //   42: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 8
    //   47: aload_0
    //   48: ldc 222
    //   50: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 9
    //   55: aload_0
    //   56: ldc 253
    //   58: invokevirtual 345	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   61: istore 5
    //   63: aload 9
    //   65: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +613 -> 681
    //   71: aload 8
    //   73: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +449 -> 525
    //   79: goto +602 -> 681
    //   82: aload_0
    //   83: ldc_w 266
    //   86: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 10
    //   91: iload 5
    //   93: ifne +578 -> 671
    //   96: iload 4
    //   98: istore_3
    //   99: aload 10
    //   101: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +21 -> 125
    //   107: new 331	java/io/File
    //   110: dup
    //   111: aload 10
    //   113: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 335	java/io/File:exists	()Z
    //   119: ifne +552 -> 671
    //   122: iload 4
    //   124: istore_3
    //   125: iload_3
    //   126: ifeq +308 -> 434
    //   129: aload 7
    //   131: ldc 253
    //   133: iload 5
    //   135: invokevirtual 349	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   138: aload 7
    //   140: ldc_w 262
    //   143: aload_0
    //   144: ldc_w 262
    //   147: invokevirtual 345	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   150: invokevirtual 349	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   153: aload 7
    //   155: ldc_w 264
    //   158: aload_0
    //   159: ldc_w 264
    //   162: invokevirtual 345	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   165: invokevirtual 349	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   168: aload 6
    //   170: ldc_w 266
    //   173: aload 10
    //   175: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   178: pop
    //   179: aload 6
    //   181: ldc_w 269
    //   184: aload 8
    //   186: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   189: pop
    //   190: aload 6
    //   192: ldc 222
    //   194: aload 9
    //   196: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   199: pop
    //   200: aload 6
    //   202: ldc_w 271
    //   205: aload_0
    //   206: ldc_w 271
    //   209: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   215: pop
    //   216: aload 7
    //   218: ldc_w 280
    //   221: aload_0
    //   222: invokestatic 355	psj:b	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   225: invokevirtual 358	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   228: aload 7
    //   230: ldc 89
    //   232: aload_0
    //   233: invokestatic 360	psj:a	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   236: invokevirtual 358	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   239: aload 7
    //   241: ldc_w 290
    //   244: aload_0
    //   245: ldc_w 290
    //   248: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 363	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 7
    //   256: ldc_w 284
    //   259: aload_0
    //   260: ldc_w 284
    //   263: invokevirtual 364	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   266: invokevirtual 368	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   269: aload 7
    //   271: ldc_w 311
    //   274: aload_0
    //   275: ldc_w 311
    //   278: invokevirtual 364	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   281: invokevirtual 368	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   284: aload 7
    //   286: ldc_w 313
    //   289: aload_0
    //   290: ldc_w 313
    //   293: invokevirtual 364	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   296: invokevirtual 368	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   299: aload 7
    //   301: ldc_w 302
    //   304: aload_0
    //   305: ldc_w 302
    //   308: invokevirtual 369	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   311: invokevirtual 373	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   314: aload 7
    //   316: ldc_w 292
    //   319: aload_0
    //   320: ldc_w 292
    //   323: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokevirtual 363	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 7
    //   331: ldc_w 294
    //   334: aload_0
    //   335: ldc_w 294
    //   338: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: invokevirtual 363	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload 7
    //   346: ldc_w 296
    //   349: aload_0
    //   350: ldc_w 296
    //   353: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   356: invokevirtual 363	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: aload 7
    //   361: ldc_w 298
    //   364: aload_0
    //   365: ldc_w 298
    //   368: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   371: invokevirtual 363	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 7
    //   376: ldc_w 300
    //   379: aload_0
    //   380: ldc_w 300
    //   383: invokevirtual 342	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   386: invokevirtual 363	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 7
    //   391: ldc_w 307
    //   394: aload_0
    //   395: ldc_w 307
    //   398: invokevirtual 364	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   401: invokevirtual 368	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   404: aload 7
    //   406: ldc_w 309
    //   409: aload_0
    //   410: ldc_w 309
    //   413: invokevirtual 364	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   416: invokevirtual 368	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   419: aload 6
    //   421: aload 7
    //   423: invokevirtual 377	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   426: pop
    //   427: aload_1
    //   428: aload 6
    //   430: invokevirtual 134	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   433: pop
    //   434: ldc 68
    //   436: iconst_1
    //   437: new 35	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 379
    //   447: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_3
    //   451: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   454: ldc_w 384
    //   457: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 10
    //   462: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: ldc_w 386
    //   468: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload 8
    //   473: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 388
    //   479: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 9
    //   484: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: return
    //   494: astore_0
    //   495: ldc 68
    //   497: iconst_1
    //   498: new 35	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 393
    //   508: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_0
    //   512: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   515: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: return
    //   525: new 331	java/io/File
    //   528: dup
    //   529: aload 8
    //   531: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   534: invokevirtual 335	java/io/File:exists	()Z
    //   537: ifne +139 -> 676
    //   540: iconst_0
    //   541: istore_2
    //   542: goto -460 -> 82
    //   545: astore 11
    //   547: invokestatic 396	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -281 -> 269
    //   553: ldc_w 398
    //   556: iconst_2
    //   557: new 35	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 400
    //   567: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload 11
    //   572: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   575: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: goto -315 -> 269
    //   587: astore 11
    //   589: invokestatic 396	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq -278 -> 314
    //   595: ldc_w 398
    //   598: iconst_2
    //   599: new 35	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 400
    //   609: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload 11
    //   614: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   617: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: goto -312 -> 314
    //   629: astore 11
    //   631: invokestatic 396	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq -245 -> 389
    //   637: ldc_w 398
    //   640: iconst_2
    //   641: new 35	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 400
    //   651: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 11
    //   656: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   659: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: goto -279 -> 389
    //   671: iload_2
    //   672: istore_3
    //   673: goto -548 -> 125
    //   676: iconst_1
    //   677: istore_2
    //   678: goto -596 -> 82
    //   681: iconst_0
    //   682: istore_2
    //   683: goto -601 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	paramString	String
    //   0	686	1	paramArrayList	ArrayList<Intent>
    //   541	142	2	bool1	boolean
    //   98	575	3	bool2	boolean
    //   1	122	4	bool3	boolean
    //   61	73	5	bool4	boolean
    //   18	411	6	localIntent	Intent
    //   27	395	7	localBundle	Bundle
    //   45	485	8	str1	String
    //   53	430	9	str2	String
    //   89	372	10	str3	String
    //   545	26	11	localException1	Exception
    //   587	26	11	localException2	Exception
    //   629	26	11	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   3	10	494	java/lang/Exception
    //   11	79	494	java/lang/Exception
    //   82	91	494	java/lang/Exception
    //   99	122	494	java/lang/Exception
    //   129	239	494	java/lang/Exception
    //   389	434	494	java/lang/Exception
    //   434	493	494	java/lang/Exception
    //   525	540	494	java/lang/Exception
    //   547	584	494	java/lang/Exception
    //   589	626	494	java/lang/Exception
    //   631	668	494	java/lang/Exception
    //   239	269	545	java/lang/Exception
    //   269	314	587	java/lang/Exception
    //   314	389	629	java/lang/Exception
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
    paramBundle = bgmq.a(obz.a(), true, true);
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
      new ntd().a(paramBundle);
    }
    a(str1);
    a(str2);
    a(str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     psj
 * JD-Core Version:    0.7.0.1
 */