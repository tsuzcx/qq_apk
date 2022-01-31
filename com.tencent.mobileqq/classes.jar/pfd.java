import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundReqBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ReqBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.RspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem;

public class pfd
  extends pgp
{
  private final ConcurrentHashMap<Integer, TopBannerInfo> a;
  
  public pfd(AppInterface paramAppInterface, awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler, pew parampew)
  {
    super(paramAppInterface, paramawgf, paramExecutorService, parampuz, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (parampew != null) {
      parampew.a(new pfe(this));
    }
  }
  
  private void a(TopBannerInfo paramTopBannerInfo)
  {
    b(paramTopBannerInfo);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramTopBannerInfo.mChannelId), paramTopBannerInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new BannerInfoModule.2(this, paramTopBannerInfo));
  }
  
  private void b(TopBannerInfo paramTopBannerInfo)
  {
    a(paramTopBannerInfo);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    paramToServiceMsg = new oidb_cmd0xbc9.RspBody();
    int i = pvb.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ReadInJoyEngineModule", 2, new Object[] { "handle0xbc9BannerInfo result = ", Integer.valueOf(i) });
    if ((i == 0) && (paramToServiceMsg.msg_banner_round_rsp_body.has()))
    {
      paramObject = (oidb_cmd0xbc9.BannerRoundRspBody)paramToServiceMsg.msg_banner_round_rsp_body.get();
      if ((!paramObject.uint32_need_update.has()) || (paramObject.uint32_need_update.get() != 1)) {
        break label453;
      }
      paramFromServiceMsg = new TopBannerInfo();
      if ((paramObject.rpt_msg_banner_list.has()) && (paramObject.rpt_msg_banner_list.size() > 0))
      {
        i = 0;
        if (i < paramObject.rpt_msg_banner_list.size())
        {
          paramToServiceMsg = (oidb_cmd0xbc9.BannerItem)paramObject.rpt_msg_banner_list.get(i);
          if (paramToServiceMsg.uint32_banner_type.has())
          {
            if (paramToServiceMsg.uint32_banner_type.get() != 2) {
              break label199;
            }
            if (!paramToServiceMsg.msg_video_banner_item.has()) {
              break label462;
            }
            paramToServiceMsg = qnj.b(paramToServiceMsg);
          }
        }
      }
    }
    label453:
    for (;;)
    {
      if (paramToServiceMsg != null) {
        paramFromServiceMsg.addItem(paramToServiceMsg);
      }
      i += 1;
      break;
      label199:
      if (paramToServiceMsg.msg_article_content_item.has())
      {
        paramToServiceMsg = qnh.b(paramToServiceMsg);
        continue;
        if (paramObject.bytes_cookie.has()) {
          paramFromServiceMsg.mCookie = paramObject.bytes_cookie.get().toStringUtf8();
        }
        if (paramObject.uint32_channel_id.has()) {
          paramFromServiceMsg.mChannelId = paramObject.uint32_channel_id.get();
        }
        if ((paramObject.rpt_msg_dynamic_banner_list.has()) && (paramObject.rpt_msg_dynamic_banner_list.size() > 0))
        {
          i = j;
          while (i < paramObject.rpt_msg_dynamic_banner_list.size())
          {
            if ((((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i)).has()) && (paramObject.rpt_msg_dynamic_banner_list.get(i) != null))
            {
              paramToServiceMsg = qng.a((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i));
              if (paramToServiceMsg != null)
              {
                paramToServiceMsg = paramToServiceMsg.iterator();
                while (paramToServiceMsg.hasNext()) {
                  paramFromServiceMsg.addDynamicItem((qng)paramToServiceMsg.next());
                }
              }
            }
            i += 1;
          }
        }
        if (paramObject.msg_more_channel_item.has())
        {
          paramToServiceMsg = qni.a((oidb_cmd0xbc9.MoreChannelItem)paramObject.msg_more_channel_item.get());
          if (paramToServiceMsg != null) {
            paramFromServiceMsg.setMoreChannelItem(paramToServiceMsg);
          }
        }
        a(paramFromServiceMsg);
        QLog.d("ReadInJoyEngineModule", 2, "handle0xbc9BannerInfo bannerInfo = " + paramFromServiceMsg);
        return;
        QLog.d("ReadInJoyEngineModule", 2, "handle0xbc9BannerInfo uint32_need_update = 0");
      }
      else
      {
        label462:
        paramToServiceMsg = null;
      }
    }
  }
  
  public TopBannerInfo a(int paramInt)
  {
    return (TopBannerInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1);
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((TopBannerInfo)localObject1).mCookie)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = new oidb_cmd0xbc9.ReqBody();
      oidb_cmd0xbc9.BannerRoundReqBody localBannerRoundReqBody = new oidb_cmd0xbc9.BannerRoundReqBody();
      localBannerRoundReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localBannerRoundReqBody.uint32_channel_id.set(paramInt1);
      ((oidb_cmd0xbc9.ReqBody)localObject1).msg_banner_round_req_body.set(localBannerRoundReqBody);
      a(pvb.a("OidbSvc.0xbc9", 3017, paramInt2, ((oidb_cmd0xbc9.ReqBody)localObject1).toByteArray()));
      QLog.d("ReadInJoyEngineModule", 2, "req banner info cookies: " + (String)localObject2 + "  channelId: " + paramInt1);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbc9")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 1);
  }
  
  public void c(int paramInt)
  {
    List localList = this.jdField_a_of_type_Awgf.a(TopBannerInfo.class, true, "mChannelId IS NOT NULL AND mChannelId == ?", new String[] { "" + paramInt }, null, null, null, "1");
    if ((localList == null) || (localList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramInt), new TopBannerInfo());
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(paramInt), localList.get(0));
  }
  
  public void d(int paramInt)
  {
    Random localRandom = new Random();
    long l = System.currentTimeMillis();
    TopBannerInfo localTopBannerInfo = new TopBannerInfo();
    localTopBannerInfo.mChannelId = paramInt;
    Object localObject = new qnh(1);
    ((qnh)localObject).jdField_c_of_type_JavaLangString = "http://qqpublic.qpic.cn/qq_public_cover/0/0-10000-7437E5B1B0F2403FBD6DDA952CE80AC1_vsmcut_160_90/0?busiType=3";
    ((qnh)localObject).f = "https://post.mp.qq.com/kan/article/2713129639-168010414.html?_wv=2147483777&sig=a039548d942f9b78b9dfab5c79284783&article_id=168010414&time=1534413057&_pflag=1&x5PreFetch=1";
    ((qnh)localObject).jdField_b_of_type_JavaLangString = alud.a(2131701288);
    ((qnh)localObject).jdField_d_of_type_JavaLangString = (alud.a(2131701295) + l);
    localTopBannerInfo.addItem((qnf)localObject);
    localObject = new qnh(3);
    ((qnh)localObject).jdField_c_of_type_JavaLangString = "http://gpic.qpic.cn/gbar_pic/aDJbaZH6aeQ9iaKenQ8IqHdg7M9kzbfsJZ3JAm4e1ICSlcpxOfcN5KQ/0";
    ((qnh)localObject).f = "https://post.mp.qq.com/kan/article/2713129639-168010414.html?_wv=2147483777&sig=a039548d942f9b78b9dfab5c79284783&article_id=168010414&time=1534413057&_pflag=1&x5PreFetch=1";
    ((qnh)localObject).a = "#F05F4C";
    ((qnh)localObject).jdField_b_of_type_JavaLangString = (alud.a(2131701291) + l);
    localTopBannerInfo.addItem((qnf)localObject);
    localObject = new qnh(4);
    ((qnh)localObject).jdField_c_of_type_JavaLangString = "http://qqpublic.qpic.cn/qq_public_cover/0/0-1533397936-401F1461EE42E7A5036F2F9AADA7E93E_open_280_280/320";
    ((qnh)localObject).f = "https://post.mp.qq.com/kan/article/2713129639-168010414.html?_wv=2147483777&sig=a039548d942f9b78b9dfab5c79284783&article_id=168010414&time=1534413057&_pflag=1&x5PreFetch=1";
    localTopBannerInfo.addItem((qnf)localObject);
    localObject = new qnj();
    ((qnj)localObject).jdField_c_of_type_JavaLangString = "http://qqpublic.qpic.cn/qq_public/0/0-3041074878-6A663B38A6407A5DDFC7A5DF6D258047/900";
    ((qnj)localObject).a = "#F05F4C";
    ((qnj)localObject).jdField_b_of_type_JavaLangString = alud.a(2131701293);
    ((qnj)localObject).jdField_d_of_type_JavaLangString = (alud.a(2131701292) + l);
    ((qnj)localObject).jdField_e_of_type_Int = 2;
    ((qnj)localObject).jdField_e_of_type_JavaLangString = "1135b6d7402114aj";
    ((qnj)localObject).jdField_d_of_type_Int = 720;
    ((qnj)localObject).jdField_c_of_type_Int = 1312;
    ((qnj)localObject).jdField_b_of_type_Long = 1635823166L;
    ((qnj)localObject).jdField_b_of_type_Int = 67;
    ((qnj)localObject).g = "te9oeA";
    localTopBannerInfo.addItem((qnf)localObject);
    paramInt = localRandom.nextInt(3);
    localTopBannerInfo.items.remove(paramInt);
    b(localTopBannerInfo);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localTopBannerInfo.mChannelId), localTopBannerInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new BannerInfoModule.4(this, localTopBannerInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pfd
 * JD-Core Version:    0.7.0.1
 */