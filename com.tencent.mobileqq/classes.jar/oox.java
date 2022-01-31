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

public class oox
  extends oqg
{
  private final ConcurrentHashMap<Integer, TopBannerInfo> a;
  
  public oox(AppInterface paramAppInterface, atmp paramatmp, ExecutorService paramExecutorService, pdc parampdc, Handler paramHandler, ooq paramooq)
  {
    super(paramAppInterface, paramatmp, paramExecutorService, parampdc, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (paramooq != null) {
      paramooq.a(new ooy(this));
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
    int i = pde.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
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
            paramToServiceMsg = prs.b(paramToServiceMsg);
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
        paramToServiceMsg = prq.b(paramToServiceMsg);
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
              paramToServiceMsg = prp.a((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i));
              if (paramToServiceMsg != null)
              {
                paramToServiceMsg = paramToServiceMsg.iterator();
                while (paramToServiceMsg.hasNext()) {
                  paramFromServiceMsg.addDynamicItem((prp)paramToServiceMsg.next());
                }
              }
            }
            i += 1;
          }
        }
        if (paramObject.msg_more_channel_item.has())
        {
          paramToServiceMsg = prr.a((oidb_cmd0xbc9.MoreChannelItem)paramObject.msg_more_channel_item.get());
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
      a(pde.a("OidbSvc.0xbc9", 3017, paramInt2, ((oidb_cmd0xbc9.ReqBody)localObject1).toByteArray()));
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
    List localList = this.jdField_a_of_type_Atmp.a(TopBannerInfo.class, true, "mChannelId IS NOT NULL AND mChannelId == ?", new String[] { "" + paramInt }, null, null, null, "1");
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
    Object localObject = new prq(1);
    ((prq)localObject).jdField_c_of_type_JavaLangString = "http://qqpublic.qpic.cn/qq_public_cover/0/0-10000-7437E5B1B0F2403FBD6DDA952CE80AC1_vsmcut_160_90/0?busiType=3";
    ((prq)localObject).f = "https://post.mp.qq.com/kan/article/2713129639-168010414.html?_wv=2147483777&sig=a039548d942f9b78b9dfab5c79284783&article_id=168010414&time=1534413057&_pflag=1&x5PreFetch=1";
    ((prq)localObject).jdField_b_of_type_JavaLangString = ajjy.a(2131635112);
    ((prq)localObject).jdField_d_of_type_JavaLangString = (ajjy.a(2131635119) + l);
    localTopBannerInfo.addItem((pro)localObject);
    localObject = new prq(3);
    ((prq)localObject).jdField_c_of_type_JavaLangString = "http://gpic.qpic.cn/gbar_pic/aDJbaZH6aeQ9iaKenQ8IqHdg7M9kzbfsJZ3JAm4e1ICSlcpxOfcN5KQ/0";
    ((prq)localObject).f = "https://post.mp.qq.com/kan/article/2713129639-168010414.html?_wv=2147483777&sig=a039548d942f9b78b9dfab5c79284783&article_id=168010414&time=1534413057&_pflag=1&x5PreFetch=1";
    ((prq)localObject).a = "#F05F4C";
    ((prq)localObject).jdField_b_of_type_JavaLangString = (ajjy.a(2131635115) + l);
    localTopBannerInfo.addItem((pro)localObject);
    localObject = new prq(4);
    ((prq)localObject).jdField_c_of_type_JavaLangString = "http://qqpublic.qpic.cn/qq_public_cover/0/0-1533397936-401F1461EE42E7A5036F2F9AADA7E93E_open_280_280/320";
    ((prq)localObject).f = "https://post.mp.qq.com/kan/article/2713129639-168010414.html?_wv=2147483777&sig=a039548d942f9b78b9dfab5c79284783&article_id=168010414&time=1534413057&_pflag=1&x5PreFetch=1";
    localTopBannerInfo.addItem((pro)localObject);
    localObject = new prs();
    ((prs)localObject).jdField_c_of_type_JavaLangString = "http://qqpublic.qpic.cn/qq_public/0/0-3041074878-6A663B38A6407A5DDFC7A5DF6D258047/900";
    ((prs)localObject).a = "#F05F4C";
    ((prs)localObject).jdField_b_of_type_JavaLangString = ajjy.a(2131635117);
    ((prs)localObject).jdField_d_of_type_JavaLangString = (ajjy.a(2131635116) + l);
    ((prs)localObject).jdField_e_of_type_Int = 2;
    ((prs)localObject).jdField_e_of_type_JavaLangString = "1135b6d7402114aj";
    ((prs)localObject).jdField_d_of_type_Int = 720;
    ((prs)localObject).jdField_c_of_type_Int = 1312;
    ((prs)localObject).jdField_b_of_type_Long = 1635823166L;
    ((prs)localObject).jdField_b_of_type_Int = 67;
    ((prs)localObject).g = "te9oeA";
    localTopBannerInfo.addItem((pro)localObject);
    paramInt = localRandom.nextInt(3);
    localTopBannerInfo.items.remove(paramInt);
    b(localTopBannerInfo);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localTopBannerInfo.mChannelId), localTopBannerInfo);
    this.jdField_a_of_type_AndroidOsHandler.post(new BannerInfoModule.4(this, localTopBannerInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oox
 * JD-Core Version:    0.7.0.1
 */