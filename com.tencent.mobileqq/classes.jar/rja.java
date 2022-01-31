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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class rja
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<rjc> jdField_a_of_type_JavaUtilList;
  private Queue<qyp> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private ntb jdField_a_of_type_Ntb;
  private ntc jdField_a_of_type_Ntc;
  private qyp jdField_a_of_type_Qyp;
  private qyy jdField_a_of_type_Qyy;
  private rjd jdField_a_of_type_Rjd;
  private rje jdField_a_of_type_Rje;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private qyp jdField_b_of_type_Qyp;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private qyp jdField_c_of_type_Qyp;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public rja(Activity paramActivity, FrameLayout paramFrameLayout, rje paramrje)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Rje = paramrje;
    this.jdField_a_of_type_AndroidOsHandler = new bhow(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = ors.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Ntb = ((ntb)paramActivity.a(90));
      this.jdField_a_of_type_Ntc = new rjf(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.c();
    }
  }
  
  private void a(qyp paramqyp1, qyp paramqyp2)
  {
    if (((paramqyp1 instanceof rjk)) && ((paramqyp2 instanceof rjk)))
    {
      paramqyp1 = (rjk)paramqyp1;
      paramqyp2 = (rjk)paramqyp2;
    }
    try
    {
      paramqyp2 = paramqyp2.a;
      if (paramqyp2 != null)
      {
        paramqyp2.mChannelID = paramqyp1.a.mChannelID;
        paramqyp2.mRecommendTime = paramqyp1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramqyp1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramqyp1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Ntb != null) && (this.jdField_b_of_type_Qyp != null)) {
      this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_Ntc, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Qyp.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Ntc != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Ntc);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Qyp.jdField_a_of_type_Int = (this.jdField_b_of_type_Qyp.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Qyp, this.jdField_c_of_type_Qyp);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Qyp != null) && (this.jdField_a_of_type_Qyy != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Qyp);
      if (this.jdField_a_of_type_Rjd != null) {
        this.jdField_a_of_type_Rjd.a(this.jdField_b_of_type_Qyp, this.jdField_c_of_type_Qyp, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Qyy.a(this.jdField_c_of_type_Qyp);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Qyp = null;
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
        rjc localrjc = (rjc)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localrjc.jdField_a_of_type_Qyp.a());
        localJSONObject2.put("playCount", localrjc.jdField_a_of_type_Int);
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
  
  public qyp a()
  {
    return this.jdField_b_of_type_Qyp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Qyp != null) {
      this.jdField_a_of_type_JavaUtilList.add(new rjc(this.jdField_b_of_type_Qyp, this.jdField_d_of_type_Int));
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
    if (this.jdField_c_of_type_Qyp != null)
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
  
  public void a(qyp paramqyp)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!bdee.h(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramqyp + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Ntc != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Ntc);
      }
      if ((paramqyp != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Qyp = paramqyp;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramqyp.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(swu.a(paramqyp.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramqyp = new ron(null, null, paramqyp.c, paramqyp.a()).a((int)paramqyp.jdField_b_of_type_Long).a().a();
      nrt.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramqyp, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(qyp paramqyp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramqyp);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Qyp = paramqyp;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Qyp != null)
    {
      if (paramqyp.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramqyp.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(qyy paramqyy)
  {
    this.jdField_a_of_type_Qyy = paramqyy;
  }
  
  public void a(rjd paramrjd)
  {
    this.jdField_a_of_type_Rjd = paramrjd;
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
  
  public void b(qyp paramqyp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramqyp);
    }
    this.jdField_c_of_type_Qyp = paramqyp;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramqyp);
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
    this.jdField_a_of_type_Ntb = null;
  }
  
  public void f()
  {
    qyp localqyp = (qyp)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localqyp == null)
    {
      g();
      return;
    }
    b(localqyp);
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
    do
    {
      do
      {
        do
        {
          return;
          b();
          if (this.jdField_a_of_type_Qyy != null) {
            this.jdField_a_of_type_Qyy.a(this.jdField_a_of_type_Qyp);
          }
        } while (this.jdField_a_of_type_Qyp == null);
        paramView = new ron(null, null, this.jdField_a_of_type_Qyp.c, this.jdField_a_of_type_Qyp.a()).a((int)this.jdField_a_of_type_Qyp.jdField_b_of_type_Long).a().a();
        nrt.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
        return;
      } while (this.jdField_a_of_type_Rjd == null);
      this.jdField_a_of_type_Rjd.j();
      return;
    } while (this.jdField_c_of_type_Qyp == null);
    paramView = new ron(null, null, this.jdField_c_of_type_Qyp.c, this.jdField_c_of_type_Qyp.a()).a((int)this.jdField_c_of_type_Qyp.jdField_b_of_type_Long).h(this.jdField_c_of_type_Qyp.a()).a().a();
    nrt.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramView, false);
    b();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rja
 * JD-Core Version:    0.7.0.1
 */