import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class spa
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<spc> jdField_a_of_type_JavaUtilList;
  private Queue<ses> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private omv jdField_a_of_type_Omv;
  private omw jdField_a_of_type_Omw;
  private ses jdField_a_of_type_Ses;
  private sff jdField_a_of_type_Sff;
  private spd jdField_a_of_type_Spd;
  private spe jdField_a_of_type_Spe;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ses jdField_b_of_type_Ses;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ses jdField_c_of_type_Ses;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public spa(Activity paramActivity, FrameLayout paramFrameLayout, spe paramspe)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Spe = paramspe;
    this.jdField_a_of_type_AndroidOsHandler = new bkys(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = pkh.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Omv = ((omv)paramActivity.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.jdField_a_of_type_Omw = new spf(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.getCurrentUin();
    }
  }
  
  private void a(ses paramses1, ses paramses2)
  {
    if (((paramses1 instanceof spk)) && ((paramses2 instanceof spk)))
    {
      paramses1 = (spk)paramses1;
      paramses2 = (spk)paramses2;
    }
    try
    {
      paramses2 = paramses2.a;
      if (paramses2 != null)
      {
        paramses2.mChannelID = paramses1.a.mChannelID;
        paramses2.mRecommendTime = paramses1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramses1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramses1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Omv != null) && (this.jdField_b_of_type_Ses != null)) {
      this.jdField_a_of_type_Omv.a(this.jdField_a_of_type_Omw, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Ses.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null, 0);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Omw != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Omw);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Ses.jdField_a_of_type_Int = (this.jdField_b_of_type_Ses.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Ses, this.jdField_c_of_type_Ses);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Ses != null) && (this.jdField_a_of_type_Sff != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Ses);
      if (this.jdField_a_of_type_Spd != null) {
        this.jdField_a_of_type_Spd.a(this.jdField_b_of_type_Ses, this.jdField_c_of_type_Ses, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Sff.a(this.jdField_c_of_type_Ses);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Ses = null;
    this.e = false;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_c_of_type_Int);
  }
  
  public String a(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        spc localspc = (spc)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localspc.jdField_a_of_type_Ses.a());
        localJSONObject2.put("playCount", localspc.jdField_a_of_type_Int);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    localJSONObject1.put("first_rowKey", paramString);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  public List<spc> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public ses a()
  {
    return this.jdField_b_of_type_Ses;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Ses != null) {
      this.jdField_a_of_type_JavaUtilList.add(new spc(this.jdField_b_of_type_Ses, this.jdField_d_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!b()) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(paramInt);
      a(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.jdField_c_of_type_Ses != null)
    {
      b();
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  public void a(ses paramses)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramses + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Omw != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Omw);
      }
      if ((paramses != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Ses = paramses;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramses.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(usq.a(paramses.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramses = new suu(null, null, paramses.c, paramses.a()).a((int)paramses.jdField_b_of_type_Long).a().a();
      olh.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramses, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(ses paramses, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramses);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Ses = paramses;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Ses != null)
    {
      if (paramses.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramses.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(sff paramsff)
  {
    this.jdField_a_of_type_Sff = paramsff;
  }
  
  public void a(spd paramspd)
  {
    this.jdField_a_of_type_Spd = paramspd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
    h();
  }
  
  public void b(ses paramses)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramses);
    }
    this.jdField_c_of_type_Ses = paramses;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramses);
    if (!this.jdField_c_of_type_Boolean) {
      a(3);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void e()
  {
    h();
    this.jdField_a_of_type_Omv = null;
  }
  
  public void f()
  {
    ses localses = (ses)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localses == null)
    {
      g();
      return;
    }
    b(localses);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l / 1000L));
        a(paramMessage.arg1);
      }
    }
    else
    {
      return true;
    }
    a(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      if (this.jdField_a_of_type_Sff != null) {
        this.jdField_a_of_type_Sff.a(this.jdField_a_of_type_Ses);
      }
      if (this.jdField_a_of_type_Ses != null)
      {
        String str = new suu(null, null, this.jdField_a_of_type_Ses.c, this.jdField_a_of_type_Ses.a()).a((int)this.jdField_a_of_type_Ses.jdField_b_of_type_Long).a().a();
        olh.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
        continue;
        if (this.jdField_a_of_type_Spd != null)
        {
          this.jdField_a_of_type_Spd.j();
          continue;
          if (this.jdField_c_of_type_Ses != null)
          {
            str = new suu(null, null, this.jdField_c_of_type_Ses.c, this.jdField_c_of_type_Ses.a()).a((int)this.jdField_c_of_type_Ses.jdField_b_of_type_Long).i(this.jdField_c_of_type_Ses.a()).a().a();
            olh.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
            b();
            j();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spa
 * JD-Core Version:    0.7.0.1
 */