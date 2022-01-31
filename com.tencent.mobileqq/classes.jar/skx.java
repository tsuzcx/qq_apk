import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stWaterFallItemStrategy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import java.util.ArrayList;
import java.util.Map;

public class skx
  implements sku
{
  private skv a;
  
  public skx(skv paramskv)
  {
    this.a = paramskv;
  }
  
  private int a()
  {
    return sjy.a().a();
  }
  
  private String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      String str = "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id;
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed.weishi_jump_url)) {
        str = paramstSimpleMetaFeed.weishi_jump_url;
      }
      return str;
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt1, String paramString, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        int i = a();
        snb.d("WSGridCardPresenter", "open weishi scheme = " + paramString + ", weishi_jump_url = " + paramstSimpleMetaFeed.weishi_jump_url);
        snd.a(paramContext.getApplicationContext(), "biz_src_jc_gzh_weishi", paramString, 1, i, paramInt2);
        if (i == 2) {
          smn.a(paramstSimpleMetaFeed, paramInt1, 1000);
        }
        smn.a(1, 114, paramInt1, paramstSimpleMetaFeed, null);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        snb.d("WSGridCardPresenter", "open weishi error scheme = " + paramString);
        return;
      }
      paramString = a(paramstSimpleMetaFeed);
    }
  }
  
  private void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    localWSDownloadParams.mEventId = 501;
    localWSDownloadParams.mTestId = smp.b();
    localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
    skn.a((Activity)paramContext, localWSDownloadParams, false);
  }
  
  private String b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id + "&logsour=2020020032";
    }
    return "";
  }
  
  private void b(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (TextUtils.equals("wifi", DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase())) {
      c(paramContext, paramInt, paramstSimpleMetaFeed);
    }
    for (;;)
    {
      smn.a(paramstSimpleMetaFeed, paramInt, 1001);
      return;
      if (sjy.a().a()) {
        c(paramContext, paramInt, paramstSimpleMetaFeed);
      } else {
        snb.a("WSGridCardPresenter", "B test do not download when 4g is not open is server");
      }
    }
  }
  
  private void c(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i = sjy.a().c();
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    Activity localActivity;
    if (i < 10000)
    {
      i = 104;
      localWSDownloadParams.mEventId = i;
      localWSDownloadParams.mTestId = smp.b();
      localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
      localObject = this.a.a();
      localActivity = (Activity)paramContext;
      if (localObject == null) {
        break label153;
      }
      paramContext = ((sjf)localObject).a();
      label97:
      if (localObject == null) {
        break label158;
      }
    }
    label153:
    label158:
    for (Object localObject = ((sjf)localObject).a();; localObject = null)
    {
      skn.a(localActivity, localWSDownloadParams, paramContext, (RockDownloadListenerWrapper)localObject);
      smn.a(1, 115, paramInt, paramstSimpleMetaFeed, skn.a(localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId));
      return;
      i = 100;
      break;
      paramContext = null;
      break label97;
    }
  }
  
  private void d(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.video != null)
    {
      stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo != null) && (!TextUtils.isEmpty(localstH5OpInfo.h5Url)))
      {
        onh.e(paramContext, localstH5OpInfo.h5Url);
        smp.a(140, localstH5OpInfo.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
        smn.a(140, 9, null);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000004, paramstSimpleMetaFeed.h5_op_info.id);
      }
    }
  }
  
  public void a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str2 = paramstSimpleMetaFeed.id;
    String str3 = paramstSimpleMetaFeed.poster_id;
    if (paramstSimpleMetaFeed.poster != null) {}
    for (String str1 = paramstSimpleMetaFeed.poster.nick;; str1 = "")
    {
      smn.a(str2, str3, str1, paramstSimpleMetaFeed.feed_desc, paramInt, 112, 1, 0);
      smp.a(true);
      if ((paramContext instanceof BaseActivity))
      {
        paramContext = bbex.a(((BaseActivity)paramContext).app, paramContext, paramstSimpleMetaFeed.video_url + "&click_index=" + (paramInt + 1));
        if (paramContext != null) {
          paramContext.c();
        }
        arji.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
        arji.b = paramstSimpleMetaFeed.feed_desc;
        arji.jdField_a_of_type_Int = paramInt;
      }
      return;
    }
  }
  
  public void a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramArrayList.add(paramstSimpleMetaFeed);
    this.a.a().c = (paramInt - 0);
    if (paramstSimpleMetaFeed.poster != null) {}
    for (String str = paramstSimpleMetaFeed.poster.id;; str = "")
    {
      snf.a(paramContext, paramArrayList, 0, str, sjy.a().a(), this.a.a().a(), 2);
      if ((paramInt != 0) || (paramstSimpleMetaFeed.video_type != 7)) {
        break;
      }
      smp.a(141, paramstSimpleMetaFeed.id);
      return;
    }
    smp.a(112, Integer.valueOf(2));
  }
  
  public void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    int i;
    Object localObject2;
    String str1;
    int j;
    String str2;
    String str3;
    String str4;
    if (paramstSimpleMetaFeed.h5_op_info != null)
    {
      smp.a(112, paramstSimpleMetaFeed.h5_op_info.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
      i = paramstSimpleMetaFeed.h5_op_info.type;
      localObject2 = paramstSimpleMetaFeed.map_pass_back;
      str1 = paramstSimpleMetaFeed.id;
      j = paramstSimpleMetaFeed.video.duration;
      str2 = paramstSimpleMetaFeed.poster_id;
      str3 = paramstSimpleMetaFeed.poster.nick;
      str4 = paramstSimpleMetaFeed.feed_desc;
      if (paramstSimpleMetaFeed.bt_style != null) {
        break label213;
      }
    }
    label213:
    for (Object localObject1 = "";; localObject1 = paramstSimpleMetaFeed.bt_style.title)
    {
      smn.a(i, (Map)localObject2, str1, j, str2, str3, str4, paramInt, "", (String)localObject1, paramstSimpleMetaFeed.h5_op_info.id);
      str1 = paramstSimpleMetaFeed.h5_op_info.h5Url;
      localObject2 = paramstSimpleMetaFeed.h5_op_info.scheme_url;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str1)))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (((String)localObject2).startsWith("weishi://")) {}
        }
      }
      else
      {
        localObject1 = b(paramstSimpleMetaFeed);
      }
      snf.a(paramContext, (String)localObject1, str1, paramstSimpleMetaFeed.h5_op_info.type, new sky(this, paramContext, paramInt, paramstSimpleMetaFeed));
      return;
    }
  }
  
  public boolean a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i;
    if (a() == 2) {
      i = 1;
    }
    while (i != 0)
    {
      sjf localsjf = this.a.a();
      if (localsjf == null)
      {
        return false;
        i = 0;
      }
      else
      {
        stWaterFallItemStrategy localstWaterFallItemStrategy = paramstSimpleMetaFeed.waterFallItemStrategy;
        boolean bool1;
        boolean bool2;
        label79:
        int j;
        if ((localstWaterFallItemStrategy != null) && (localstWaterFallItemStrategy.isCallWeishi))
        {
          bool1 = true;
          if ((localstWaterFallItemStrategy == null) || (!localstWaterFallItemStrategy.isDonwloadWeish)) {
            break label301;
          }
          bool2 = true;
          i = sjy.a().b();
          j = sjy.a().c();
          if (!vzw.a(BaseApplicationImpl.getApplication())) {
            break label322;
          }
          bool2 = sjy.a().b();
          snb.d("WSGridCardPresenter", "openCallWeishi = " + bool1 + ", isOpenVideoPage = " + bool2 + ", callCount = " + i + ", openCallWSCount = " + localsjf.jdField_a_of_type_Int);
          smp.a(112, Integer.valueOf(114));
          WSPublicAccReport.getInstance().feedsItemReport("gzh_click", snf.a(1), paramstSimpleMetaFeed, smn.a(paramstSimpleMetaFeed, paramInt), 1000003);
          if ((!bool1) || (localsjf.jdField_a_of_type_Int >= i)) {
            break;
          }
          localsjf.jdField_a_of_type_Int += 1;
          if (i >= 10000) {
            break label307;
          }
          i = 104;
          label246:
          if (bool2) {
            a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed);
          }
          a(paramContext, paramInt, paramstSimpleMetaFeed.weishi_jump_url, paramstSimpleMetaFeed, i);
          if (!bool2) {
            break label314;
          }
        }
        label301:
        label307:
        label314:
        for (i = 143;; i = 142)
        {
          smn.a(paramstSimpleMetaFeed, paramInt, i);
          return true;
          bool1 = false;
          break;
          bool2 = false;
          break label79;
          i = 100;
          break label246;
        }
        label322:
        snb.d("WSGridCardPresenter", "openDownloadWeishi = " + bool2 + ", downloadCount = " + j + ", openDownloadWSCount = " + sjf.b);
        smp.a(112, Integer.valueOf(115));
        WSPublicAccReport.getInstance().feedsItemReport("gzh_click", snf.a(1), paramstSimpleMetaFeed, smn.a(paramstSimpleMetaFeed, paramInt), 1000002);
        if ((bool2) && (sjf.b < j))
        {
          a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed);
          b(paramContext, paramInt, paramstSimpleMetaFeed);
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skx
 * JD-Core Version:    0.7.0.1
 */