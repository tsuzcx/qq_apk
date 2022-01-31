import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class qjf
{
  public int a;
  public VideoInfo.GameAdComData a;
  public AdvertisementInfo a;
  public AdData a;
  public WadlParams a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "";
  public String h = "";
  public String i;
  
  public qjf()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static String a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramVideoAdInfo.r != null)
        {
          paramVideoAdInfo = new JSONObject(paramVideoAdInfo.r).optString("pkg_name");
          return paramVideoAdInfo;
        }
      }
      catch (JSONException paramVideoAdInfo)
      {
        paramVideoAdInfo.printStackTrace();
        QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + paramVideoAdInfo.toString());
      }
    }
    return null;
  }
  
  /* Error */
  public static qjf a(VideoAdInfo paramVideoAdInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 41	com/tencent/biz/pubaccount/VideoAdInfo:r	Ljava/lang/String;
    //   10: ifnull +144 -> 154
    //   13: new 43	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: getfield 41	com/tencent/biz/pubaccount/VideoAdInfo:r	Ljava/lang/String;
    //   21: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: new 2	qjf
    //   28: dup
    //   29: invokespecial 78	qjf:<init>	()V
    //   32: astore_2
    //   33: aload_2
    //   34: aload_1
    //   35: ldc 80
    //   37: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: putfield 82	qjf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 84	com/tencent/biz/pubaccount/VideoAdInfo:f	Ljava/lang/String;
    //   48: putfield 86	qjf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: aload_2
    //   52: aload_1
    //   53: ldc 48
    //   55: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: putfield 88	qjf:d	Ljava/lang/String;
    //   61: aload_2
    //   62: aload_1
    //   63: ldc 90
    //   65: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: putfield 92	qjf:e	Ljava/lang/String;
    //   71: aload_2
    //   72: aconst_null
    //   73: putfield 94	qjf:c	Ljava/lang/String;
    //   76: aload_2
    //   77: iconst_0
    //   78: putfield 96	qjf:jdField_b_of_type_Int	I
    //   81: aload_2
    //   82: iconst_0
    //   83: putfield 26	qjf:jdField_a_of_type_Int	I
    //   86: aload_2
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 99	com/tencent/biz/pubaccount/VideoAdInfo:t	Ljava/lang/String;
    //   92: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +13 -> 108
    //   98: aload_2
    //   99: aload_0
    //   100: getfield 99	com/tencent/biz/pubaccount/VideoAdInfo:t	Ljava/lang/String;
    //   103: putfield 106	qjf:f	Ljava/lang/String;
    //   106: aload_2
    //   107: astore_1
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_0
    //   114: invokevirtual 55	org/json/JSONException:printStackTrace	()V
    //   117: ldc 57
    //   119: iconst_1
    //   120: new 59	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   127: ldc 62
    //   129: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 70	org/json/JSONException:toString	()Ljava/lang/String;
    //   136: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto -37 -> 108
    //   148: astore_0
    //   149: aload_2
    //   150: astore_1
    //   151: goto -38 -> 113
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -48 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramVideoAdInfo	VideoAdInfo
    //   24	132	1	localObject	Object
    //   32	118	2	localqjf	qjf
    // Exception table:
    //   from	to	target	type
    //   6	33	110	org/json/JSONException
    //   33	86	148	org/json/JSONException
    //   88	106	148	org/json/JSONException
  }
  
  /* Error */
  public static qjf a(VideoInfo.GameAdComData paramGameAdComData)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 112	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:s	Ljava/lang/String;
    //   10: ifnull +177 -> 187
    //   13: new 43	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: getfield 112	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:s	Ljava/lang/String;
    //   21: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_0
    //   26: new 114	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 117	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo:<init>	(Lorg/json/JSONObject;)V
    //   34: putfield 120	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:a	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo;
    //   37: new 2	qjf
    //   40: dup
    //   41: invokespecial 78	qjf:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 121	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:g	Ljava/lang/String;
    //   50: putfield 82	qjf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 122	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:d	Ljava/lang/String;
    //   58: putfield 88	qjf:d	Ljava/lang/String;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 123	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:c	Ljava/lang/String;
    //   66: putfield 92	qjf:e	Ljava/lang/String;
    //   69: aload_1
    //   70: aload_2
    //   71: ldc 125
    //   73: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 94	qjf:c	Ljava/lang/String;
    //   79: aload_1
    //   80: iconst_0
    //   81: putfield 96	qjf:jdField_b_of_type_Int	I
    //   84: aload_1
    //   85: iconst_0
    //   86: putfield 26	qjf:jdField_a_of_type_Int	I
    //   89: aload_1
    //   90: iconst_1
    //   91: putfield 127	qjf:jdField_a_of_type_Boolean	Z
    //   94: aload_1
    //   95: aload_0
    //   96: putfield 129	qjf:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdComData;
    //   99: new 43	org/json/JSONObject
    //   102: dup
    //   103: aload_0
    //   104: getfield 132	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:A	Ljava/lang/String;
    //   107: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: astore_0
    //   111: aload_1
    //   112: aload_0
    //   113: ldc 134
    //   115: ldc 28
    //   117: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 32	qjf:h	Ljava/lang/String;
    //   123: aload_1
    //   124: aload_0
    //   125: ldc 139
    //   127: ldc 28
    //   129: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 30	qjf:g	Ljava/lang/String;
    //   135: aload_1
    //   136: areturn
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: astore_1
    //   142: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq -10 -> 135
    //   148: ldc 57
    //   150: iconst_1
    //   151: new 59	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   158: ldc 62
    //   160: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 70	org/json/JSONException:toString	()Ljava/lang/String;
    //   167: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: astore_1
    //   178: goto -43 -> 135
    //   181: astore_2
    //   182: aload_1
    //   183: astore_0
    //   184: goto -44 -> 140
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -54 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramGameAdComData	VideoInfo.GameAdComData
    //   44	145	1	localObject	Object
    //   24	47	2	localJSONObject	JSONObject
    //   137	27	2	localJSONException1	JSONException
    //   181	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   6	45	137	org/json/JSONException
    //   45	135	181	org/json/JSONException
  }
  
  public static qjf a(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo, false);
  }
  
  public static qjf a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {
      return null;
    }
    Object localObject2;
    try
    {
      if (oau.a(paramAdvertisementInfo) == 2)
      {
        localObject3 = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        localObject2 = new qjf();
        localObject1 = localObject2;
      }
    }
    catch (JSONException paramAdvertisementInfo)
    {
      Object localObject3;
      JSONObject localJSONObject;
      Object localObject1 = null;
      label323:
      paramAdvertisementInfo.printStackTrace();
      QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + paramAdvertisementInfo.toString());
      localObject2 = localObject1;
    }
    try
    {
      ((qjf)localObject2).jdField_a_of_type_Boolean = true;
      localObject1 = localObject2;
      ((qjf)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("game_app_id");
      localObject1 = localObject2;
      ((qjf)localObject2).d = ((JSONObject)localObject3).optString("game_pkg_name");
      localObject1 = localObject2;
      ((qjf)localObject2).e = ((JSONObject)localObject3).optString("game_app_name");
      localObject1 = localObject2;
      ((qjf)localObject2).c = ((JSONObject)localObject3).optString("game_apk_url");
      localObject1 = localObject2;
      ((qjf)localObject2).g = ((JSONObject)localObject3).optString("game_adtag");
      localObject1 = localObject2;
      ((qjf)localObject2).h = ((JSONObject)localObject3).optString("__ADSTR__");
      localObject1 = localObject2;
      ((qjf)localObject2).jdField_b_of_type_Int = 0;
      localObject1 = localObject2;
      ((qjf)localObject2).jdField_a_of_type_Int = 0;
      localObject1 = localObject2;
      ((qjf)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
      return localObject2;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      break label323;
      localObject2 = null;
    }
    if (paramAdvertisementInfo.mAdExt != null)
    {
      localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExt);
      localObject3 = new qjf();
      localObject1 = localObject3;
      ((qjf)localObject3).jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
      if (paramBoolean) {
        localObject1 = localObject3;
      }
      for (localObject2 = paramAdvertisementInfo.mAdRl;; localObject2 = paramAdvertisementInfo.mAdDownloadApiUrl)
      {
        localObject1 = localObject3;
        ((qjf)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject2);
        localObject1 = localObject3;
        ((qjf)localObject3).d = localJSONObject.optString("pkg_name");
        localObject1 = localObject3;
        ((qjf)localObject3).e = localJSONObject.optString("appname");
        localObject1 = localObject3;
        ((qjf)localObject3).c = "";
        localObject1 = localObject3;
        ((qjf)localObject3).jdField_b_of_type_Int = 0;
        localObject1 = localObject3;
        ((qjf)localObject3).jdField_a_of_type_Int = 0;
        localObject1 = localObject3;
        ((qjf)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (TextUtils.isEmpty(paramAdvertisementInfo.mAdVia)) {
          break;
        }
        localObject1 = localObject3;
        ((qjf)localObject3).f = paramAdvertisementInfo.mAdVia;
        localObject2 = localObject3;
        break;
        localObject1 = localObject3;
      }
    }
    return localObject2;
  }
  
  public static qjf a(AdData paramAdData)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return null;
    }
    qjf localqjf = new qjf();
    localqjf.jdField_a_of_type_JavaLangString = paramAdData.a.c;
    localqjf.jdField_b_of_type_JavaLangString = paramAdData.a.jdField_a_of_type_JavaLangString;
    localqjf.d = paramAdData.a.jdField_b_of_type_JavaLangString;
    localqjf.e = paramAdData.a.d;
    localqjf.c = paramAdData.a.e;
    localqjf.jdField_b_of_type_Int = 0;
    localqjf.jdField_a_of_type_Int = 0;
    localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    if (!TextUtils.isEmpty(paramAdData.A)) {
      localqjf.f = paramAdData.A;
    }
    if (oal.a(paramAdData)) {
      localqjf.jdField_a_of_type_Boolean = true;
    }
    localqjf.g = paramAdData.S;
    localqjf.h = paramAdData.R;
    localqjf.i = paramAdData.Q;
    return localqjf;
  }
  
  public static qjf a(nyi paramnyi)
  {
    if (paramnyi == null) {
      return null;
    }
    qjf localqjf = new qjf();
    localqjf.jdField_a_of_type_JavaLangString = paramnyi.o;
    localqjf.jdField_b_of_type_JavaLangString = paramnyi.q;
    localqjf.d = paramnyi.n;
    localqjf.e = paramnyi.p;
    localqjf.c = paramnyi.q;
    localqjf.g = paramnyi.u;
    localqjf.h = paramnyi.v;
    localqjf.jdField_b_of_type_Int = 0;
    localqjf.jdField_a_of_type_Int = 0;
    localqjf.jdField_a_of_type_Boolean = true;
    return localqjf;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.c);
  }
  
  public boolean a(qjf paramqjf)
  {
    return (paramqjf != null) && (paramqjf.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramqjf.d.equals(this.d)) && (paramqjf.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (qjf)paramObject;
      if (this.c != null)
      {
        if (this.c.equals(paramObject.c)) {}
      }
      else {
        while (paramObject.c != null) {
          return false;
        }
      }
      if (this.d != null) {
        return this.d.equals(paramObject.d);
      }
    } while (paramObject.d == null);
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    if (this.c != null) {}
    for (int j = this.c.hashCode();; j = 0)
    {
      if (this.d != null) {
        k = this.d.hashCode();
      }
      return j * 31 + k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjf
 * JD-Core Version:    0.7.0.1
 */