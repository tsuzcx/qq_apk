import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteReqBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.ReqBody;

public class ptf
{
  public static final String a;
  static HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  public static ptf a;
  public static final String b;
  public static final String c;
  public static final String d;
  private pub jdField_a_of_type_Pub = new pub();
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + ptf.class.getSimpleName();
    b = amtj.a(2131712013);
    c = amtj.a(2131711924);
    d = amtj.a(2131712084);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), b);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), c);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), d);
  }
  
  public static ptf a()
  {
    if (jdField_a_of_type_Ptf == null) {}
    try
    {
      if (jdField_a_of_type_Ptf == null) {
        jdField_a_of_type_Ptf = new ptf();
      }
      return jdField_a_of_type_Ptf;
    }
    finally {}
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<byte[]> paramArrayList)
  {
    new bkov(6).a("nLinkType", 0).b("sTitle", paramString2).b("sUrl", paramString6).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramString4).b("sBrief", paramString3).b("sPath", paramString5).b("sResUrl", paramString6).a("lCategory", 8L).b("sBizDataList", paramArrayList).b(paramActivity, paramString1, -1, null);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (pay.a(BaseApplicationImpl.getApplication().getRuntime(), "Key_First_ReadInJoy_Favorite", true) == null)
    {
      pay.a("Key_First_ReadInJoy_Favorite", Integer.valueOf(1), true);
      if (!paramBoolean) {
        bfur.a(paramContext, 230, paramContext.getString(2131692081), "你可在看点内点击“我的”找到“我的收藏”。\n收藏的内容将会上传保存，在其他手机上登录QQ，也可以在看点内找到你收藏的内容。\n", 2131690620, 2131692079, new pth(), null).setMessageCount(null).show();
      }
      bool = true;
    }
    return bool;
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    a(paramActivity, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, paramString6, paramBundle, false);
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, boolean paramBoolean)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("videoDuration");
      localKandianFavoriteBizData.uint32_video_duration.set(paramInt);
      paramInt = paramBundle.getInt("picNum");
      localKandianFavoriteBizData.uint32_pic_num.set(paramInt);
      long l = paramBundle.getLong("publishAccountUin");
      localKandianFavoriteBizData.uint64_account_id.set(l);
      paramString2 = paramBundle.getString("publishAccountName");
      if (!TextUtils.isEmpty(paramString2))
      {
        localKandianFavoriteBizData.bytes_account_name.set(ByteStringMicro.copyFromUtf8(paramString2));
        l = paramBundle.getLong("feedsId");
        localKandianFavoriteBizData.uint64_feeds_id.set(l);
        paramInt = paramBundle.getInt("feedsType");
        localKandianFavoriteBizData.uint32_feeds_type.set(paramInt);
        paramInt = paramBundle.getInt("videoType");
        localKandianFavoriteBizData.uint32_video_type.set(paramInt);
      }
    }
    for (;;)
    {
      localArrayList.add(localKandianFavoriteBizData.toByteArray());
      if (paramBoolean)
      {
        new bkov(6).a("nLinkType", 0).b("sTitle", paramString3).b("sUrl", paramString6).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramString2).b("sBrief", paramString4).b("sPath", paramString5).b("sResUrl", paramString6).a("lCategory", 8L).b("sBizDataList", localArrayList).a(paramActivity, paramString1);
        return;
      }
      a(paramActivity, paramString1, paramString3, paramString4, paramString2, paramString5, paramString6, localArrayList);
      return;
      paramString2 = "";
      break;
      paramString2 = "";
    }
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, ArrayList<String> paramArrayList)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    paramString2 = new ArrayList();
    paramString2.add(localKandianFavoriteBizData.toByteArray());
    new bkov(6).a("sCIDListToBeDelete", paramArrayList).b("sBizDataList", paramString2).a(paramActivity, paramString1, -1, null);
  }
  
  public void a(List<String> paramList, pti parampti)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAtlasFavoriteStatus, rowKeyList = " + paramList + ", callback = " + parampti);
    }
    oidb_0xb40.ReqBody localReqBody = new oidb_0xb40.ReqBody();
    oidb_0xb40.CheckFavoriteReqBody localCheckFavoriteReqBody = new oidb_0xb40.CheckFavoriteReqBody();
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        localCheckFavoriteReqBody.rpt_bytes_rowkey.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localReqBody.msg_check_favorite_req.set(localCheckFavoriteReqBody);
    paramList = new Bundle();
    nmb.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ptg(this, parampti), localReqBody.toByteArray(), "OidbSvc.0xb40", 2880, 1, paramList, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptf
 * JD-Core Version:    0.7.0.1
 */