import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushOpModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import java.util.HashMap;
import org.json.JSONObject;

public class rzw
{
  public static String a()
  {
    String str = "Other";
    int i = badq.a(BaseApplicationImpl.getApplication());
    if (i == 1) {
      str = "WiFi";
    }
    do
    {
      return str;
      if (i == 2) {
        return "2G";
      }
      if (i == 3) {
        return "3G";
      }
    } while (i != 4);
    return "4G";
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "weishi_share_officialacc";
    }
    if (paramInt == 2) {
      return "weishi_share_trendstab";
    }
    return "";
  }
  
  public static String a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool = true;
    if (paramstSimpleMetaFeed == null) {
      return "";
    }
    stWaterFallCardStyle localstWaterFallCardStyle = paramstSimpleMetaFeed.waterFallCardStyle;
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", Integer.valueOf(paramInt + 1));
    if (localstWaterFallCardStyle != null)
    {
      paramInt = localstWaterFallCardStyle.cardType;
      localHashMap.put("cardtype", Integer.valueOf(paramInt));
      localHashMap.put("feedid", paramstSimpleMetaFeed.id);
      localHashMap.put("poolType", Integer.valueOf(paramstSimpleMetaFeed.videoPoolType));
      if (localstWaterFallCardStyle == null) {
        break label192;
      }
      paramInt = localstWaterFallCardStyle.ratioW;
      label94:
      localHashMap.put("ratioW", Integer.valueOf(paramInt));
      if (localstWaterFallCardStyle == null) {
        break label197;
      }
      paramInt = localstWaterFallCardStyle.ratioH;
      label115:
      localHashMap.put("ratioH", Integer.valueOf(paramInt));
      if ((localstWaterFallCardStyle == null) || (!localstWaterFallCardStyle.isFullSpan)) {
        break label202;
      }
    }
    for (;;)
    {
      localHashMap.put("isFullSpan", Boolean.valueOf(bool));
      localHashMap.put("dynamic_cover", Integer.valueOf(0));
      localHashMap.put("cover_type", sam.a(paramstSimpleMetaFeed));
      return new JSONObject(localHashMap).toString();
      paramInt = 1;
      break;
      label192:
      paramInt = 0;
      break label94;
      label197:
      paramInt = 0;
      break label115;
      label202:
      bool = false;
    }
  }
  
  private static String a(int paramInt, boolean paramBoolean)
  {
    String str1 = "";
    String str2 = "";
    switch (paramInt)
    {
    }
    while (paramBoolean)
    {
      return str1;
      str1 = "videolay_prof_dl_fin";
      str2 = "videolay_prof_install";
      continue;
      str1 = "videoplay_title_dl_fin";
      str2 = "videoplay_title_install";
      continue;
      str1 = "popup_dl_fin";
      str2 = "popup_install";
      continue;
      str1 = "popup_dl_ws_fin";
      str2 = "popup_ws_install";
      continue;
      str1 = "follow_dl_fin";
      str2 = "follow_install";
      continue;
      str1 = "videolay_tag_dl_fin";
      str2 = "videolay_tag_install";
      continue;
      str1 = "msg_dl_fin";
      str2 = "msg_install";
      continue;
      str1 = "feeds_dl_ws_fin";
      str2 = "feeds_dl_ws_install";
      continue;
      str1 = "dtest_dl_fin";
      str2 = "dtest_dl_install";
      continue;
      str1 = "lens_dl_ws_fin";
      str2 = "lens_install";
      continue;
      str1 = "feeds_popup_dl_fin";
      str2 = "feeds_popup_install";
      continue;
      str1 = "feeds_opcard_dl_ws_fin";
      str2 = "feeds_opcard_install_ws";
      continue;
      str1 = "ftest_dl_ws_fin";
      str2 = "ftest_dl_ws_install";
    }
    return str2;
  }
  
  public static String a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    String str1;
    boolean bool;
    if (paramWSRedDotPushMsg != null)
    {
      str1 = paramWSRedDotPushMsg.mFeedIds;
      String str2 = paramWSRedDotPushMsg.mPushId;
      bool = sam.a(paramWSRedDotPushMsg);
      paramWSRedDotPushMsg = str2;
    }
    for (;;)
    {
      localHashMap.put("feed_id", str1);
      localHashMap.put("push_id", paramWSRedDotPushMsg);
      if (bool) {
        i = 1;
      }
      localHashMap.put("preload_status", Integer.valueOf(i));
      localHashMap.put("networkType", a());
      localHashMap.put("ipAddress", DeviceUtils.getLocalIpAddress());
      return new JSONObject(localHashMap).toString();
      str1 = "0";
      paramWSRedDotPushMsg = "0";
      bool = false;
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "0";
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = "0";
    }
    localHashMap.put("feed_id", str);
    localHashMap.put("push_id", paramString2);
    localHashMap.put("preload_status", Integer.valueOf(paramInt2));
    localHashMap.put("feeds_list_type", Integer.valueOf(paramInt3));
    localHashMap.put("preload_count", Integer.valueOf(paramInt1));
    localHashMap.put("networkType", a());
    localHashMap.put("ipAddress", DeviceUtils.getLocalIpAddress());
    return new JSONObject(localHashMap).toString();
  }
  
  public static void a()
  {
    a("officialacc_weishi", "feeds_clk", 0, 0, -1L, 0L, "", b());
    a("weishi_share_officialacc", "feeds_clk_ws", 0, 0, -1L, 0L, "", b());
  }
  
  public static void a(int paramInt)
  {
    a("weishi_share_officialacc", "start_dl_ws_fin", paramInt, 0, rxf.a().d(), 0L, "", "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a("weishi_share_officialacc", "start_install_ws", paramInt2, 0, paramInt1, 0L, "", "");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    sai.c("898", "optionId:" + paramInt3);
    String str1 = sam.a(4);
    String str2 = String.valueOf(paramInt3);
    switch (paramInt1)
    {
    default: 
      return;
    case 6: 
      a("weishi_share_officialacc", "msg_entry_exp", paramInt2, 0, 0L, 0L, str2, str1);
      return;
    case 115: 
      a("weishi_share_officialacc", "msg_dl_ws", paramInt2, 0, 0L, 0L, str2, str1);
      return;
    case 114: 
      a("weishi_share_officialacc", "msg_clk_ws", paramInt2, 0, 0L, 0L, str2, str1);
      return;
    case 140: 
      a("weishi_share_officialacc", "msg_clk_h5", paramInt2, 0, 0L, 0L, str2, str1);
      return;
    }
    a("weishi_share_officialacc", "msg_clk", paramInt2, 0, 0L, 0L, str2, str1);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 += 1;
    sai.d("898", "optionId:" + paramInt4);
    String str = String.valueOf(paramInt4);
    switch (paramInt1)
    {
    default: 
      return;
    case 6: 
      a("weishi_share_officialacc", "feeds_op_card_exp", paramInt2, 0, paramInt3, 0L, str, b());
      return;
    case 112: 
      a("weishi_share_officialacc", "feeds_op_card_clk", paramInt2, 0, paramInt3, 0L, str, b());
      return;
    case 115: 
      a("weishi_share_officialacc", "feeds_opcard_dl_ws", paramInt2, 0, paramInt3, 0L, str, b());
      return;
    case 114: 
      a("weishi_share_officialacc", "feeds_opcard_clk_ws", paramInt2, 0, paramInt3, 0L, str, b());
      return;
    }
    a("weishi_share_officialacc", "feeds_opcard_clk_h5", paramInt2, 0, paramInt3, 0L, str, b());
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString)
  {
    a("officialacc_weishi", "gzh_clk_H5", paramInt1, 0, paramInt2, 0L, paramString, "");
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (!(paramObject instanceof String));
              a("officialacc_weishi", "single_video_exp", 0, 0, 0L, 0L, (String)paramObject, b());
              return;
            } while (!paramObject.getClass().isArray());
            paramObject = (Object[])paramObject;
            long l = ((Long)paramObject[0]).longValue();
            paramInt = ((Integer)paramObject[1]).intValue();
            a("officialacc_weishi", "officialacc_quit", 0, (int)l, paramInt, 0L, "", "");
            return;
            str = c();
            if ((paramObject instanceof String)) {
              str = (String)paramObject;
            }
            a("officialacc_weishi", "feeds_exp", 0, 0, 0L, 0L, str, "");
            return;
          } while (!(paramObject instanceof String));
          a("officialacc_weishi", "push_video_clk", 0, 0, 0L, 0L, (String)paramObject, b());
          return;
          if ((paramObject instanceof String))
          {
            a("officialacc_weishi", "feeds_clk", 0, 0, 0L, 0L, (String)paramObject, b());
            return;
          }
        } while (!(paramObject instanceof Integer));
        switch (((Integer)paramObject).intValue())
        {
        default: 
          return;
        case 2: 
          a("officialacc_weishi", "feeds_clk_videoplay", 0, 0, 0L, 0L, "", b());
          return;
        case 115: 
          a("weishi_share_officialacc", "feeds_dl_ws", 0, 0, 0L, 0L, "", b());
          return;
        }
        a("weishi_share_officialacc", "feeds_clk_ws", 0, 0, 0L, 0L, "", b());
        return;
      } while ((!(paramObject instanceof Integer)) || (((Integer)paramObject).intValue() != 4));
      a("weishi_share_officialacc", "dtest_dl_ws", 0, 0, 0L, 0L, "", b());
      return;
      String str = "";
      if (paramObject.getClass().isArray())
      {
        paramObject = (Object[])paramObject;
        paramInt = ((Integer)paramObject[0]).intValue();
        str = (String)paramObject[1];
        switch (paramInt)
        {
        default: 
          a("officialacc_weishi", "feeds_video_exp", 0, 0, 0L, 0L, "", b());
        }
      }
      for (;;)
      {
        a("officialacc_weishi", "feeds_exp_cpl", 0, 0, 0L, 0L, str, b());
        return;
        a("weishi_share_officialacc", "feeds_dl_exp", 0, 0, 0L, 0L, "", b());
      }
    } while (!paramObject.getClass().isArray());
    paramObject = (Object[])paramObject;
    a("officialacc_weishi", "feeds_load_fail", ((Integer)paramObject[0]).intValue(), 0, ((Long)paramObject[1]).longValue(), 0L, "", "");
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    a("weishi_share_officialacc", a(paramInt, paramBoolean), 0, 0, 0L, 0L, "", "");
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {
      a("officialacc_weishi", "weishi_share_officialacc", paramBoolean1, paramBoolean2);
    }
    while (paramInt != 2) {
      return;
    }
    a("trandstab_weishi", "weishi_share_trendstab", paramBoolean1, paramBoolean2);
  }
  
  public static void a(WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    if (paramWSDownloadParams == null) {
      return;
    }
    a("weishi_share_officialacc", "start_dl_ws", paramInt, 0, rxf.a().d(), 0L, "", paramWSDownloadParams.mTestId);
  }
  
  public static void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    IWSPushBaseStrategy localIWSPushBaseStrategy;
    Object localObject;
    int i;
    int k;
    int j;
    if (paramWSRedDotPushMsg != null)
    {
      localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
      if (!(localIWSPushBaseStrategy instanceof WSPushStrategyInfo)) {
        break label134;
      }
      localObject = (WSPushStrategyInfo)localIWSPushBaseStrategy;
      if (((WSPushStrategyInfo)localObject).mWSPushModel == null) {
        break label129;
      }
      i = ((WSPushStrategyInfo)localObject).mWSPushModel.a;
      k = ((WSPushStrategyInfo)localObject).getType();
      j = i;
      i = k;
    }
    for (;;)
    {
      k = i;
      if (i == 3) {
        k = 1;
      }
      long l1;
      long l2;
      if (vnd.a(BaseApplicationImpl.getApplication().getApplicationContext()))
      {
        l1 = 1L;
        l2 = j;
        localObject = paramWSRedDotPushMsg.mPushId;
        if (localIWSPushBaseStrategy == null) {
          break label123;
        }
      }
      label123:
      for (paramWSRedDotPushMsg = localIWSPushBaseStrategy.getAbTest();; paramWSRedDotPushMsg = "")
      {
        a("officialacc_weishi", "push_text_clk", k, 0, l1, l2, (String)localObject, paramWSRedDotPushMsg);
        return;
        l1 = 0L;
        break;
      }
      label129:
      i = 0;
      break;
      label134:
      i = 0;
      j = 0;
    }
  }
  
  public static void a(WSRedDotPushMsg paramWSRedDotPushMsg, boolean paramBoolean)
  {
    int i;
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      i = paramWSRedDotPushMsg.mStrategyInfo.getType();
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (paramWSRedDotPushMsg = "1";; paramWSRedDotPushMsg = "2")
    {
      a("trandstab_weishi", "trandstab_clk", i, 0, 0L, 0L, paramWSRedDotPushMsg, "");
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString3, String paramString4)
  {
    awqx.b(null, "dc00898", "", "", paramString1, paramString2, paramInt1, paramInt2, String.valueOf(paramLong1), String.valueOf(paramLong2), paramString3, paramString4);
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(paramString1, "network_popup_exp", 0, 0, 0L, 0L, "", "");
      return;
    }
    if (paramBoolean2)
    {
      a(paramString2, "network_dl_confirm", 0, 0, 0L, 0L, "", "");
      return;
    }
    a(paramString1, "network_dl_cancel", 0, 0, 0L, 0L, "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("weishi_share_zhibo", "zhibo_feeds_clk", 0, 0, 0L, 0L, "", b());
      return;
    }
    a("weishi_share_zhibo", "zhibo_feeds_exp", 0, 0, 0L, 0L, "", b());
  }
  
  public static void a(boolean paramBoolean, WSDownloadParams paramWSDownloadParams)
  {
    if (paramWSDownloadParams == null) {}
    String str;
    do
    {
      return;
      str = a(paramWSDownloadParams.mScene);
    } while (TextUtils.isEmpty(str));
    if (paramBoolean)
    {
      a(str, "dl_clk_QQdownloader", 0, 0, 0L, 0L, "", paramWSDownloadParams.mTestId);
      return;
    }
    a(str, "dl_clk_officialdownloader", rxf.a().d(), 0, 0L, 0L, "", paramWSDownloadParams.mTestId);
  }
  
  public static String b()
  {
    return sam.a(1);
  }
  
  public static void b()
  {
    a("trandstab_weishi", "push_clk", 0, 0, 0L, 0L, "", "");
  }
  
  public static void b(int paramInt)
  {
    a("weishi_share_officialacc", "start_install_ws_fin", paramInt, 0, 0L, 0L, "", "");
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3)
  {
    sai.c("898", "optionId:" + paramInt3);
    String str = String.valueOf(paramInt3);
    switch (paramInt1)
    {
    default: 
      return;
    case 6: 
      a("officialacc_weishi", "comment_popup_exp", 0, 0, 0L, 0L, str, "");
      return;
    }
    a("weishi_share_officialacc", "comment_popup_clk", paramInt2, 0, 0L, 0L, str, "");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("officialacc_weishi", "blanktips_clk", 0, 0, 0L, 0L, "", "");
      return;
    }
    a("officialacc_weishi", "blanktips_exp", 0, 0, 0L, 0L, "", "");
  }
  
  private static String c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("networkType", a());
    localHashMap.put("ipAddress", DeviceUtils.getLocalIpAddress());
    return new JSONObject(localHashMap).toString();
  }
  
  public static void c(int paramInt)
  {
    if (paramInt == 2) {
      a("officialacc_weishi", "videoplay_update_exp", 0, 0, 0L, 0L, "", "");
    }
    while (paramInt != 6) {
      return;
    }
    a("trandstab_weishi", "videoplay_update_exp", 0, 0, 0L, 0L, "", "");
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3)
  {
    sai.d("898", "optionId:" + paramInt3);
    String str = String.valueOf(paramInt3);
    switch (paramInt1)
    {
    default: 
      return;
    case 6: 
      a("weishi_share_officialacc", "feeds_popup_exp", paramInt2, 0, 0L, 0L, str, b());
      return;
    case 112: 
      a("weishi_share_officialacc", "feeds_popup_clk", paramInt2, 0, 0L, 0L, str, b());
      return;
    case 115: 
      a("weishi_share_officialacc", "feeds_popup_dl_ws", paramInt2, 0, 0L, 0L, str, b());
      return;
    case 114: 
      a("weishi_share_officialacc", "feeds_popup_clk_ws", paramInt2, 0, 0L, 0L, str, b());
      return;
    }
    a("officialacc_weishi", "feeds_popup_close", paramInt2, 0, 0L, 0L, str, b());
  }
  
  public static void d(int paramInt)
  {
    a("trandstab_weishi", "trandstab_clk_H5", paramInt, 0, 0L, 0L, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzw
 * JD-Core Version:    0.7.0.1
 */