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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class rvs
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<rvu> jdField_a_of_type_JavaUtilList;
  private Queue<rld> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private odp jdField_a_of_type_Odp;
  private odq jdField_a_of_type_Odq;
  private rld jdField_a_of_type_Rld;
  private rlq jdField_a_of_type_Rlq;
  private rvv jdField_a_of_type_Rvv;
  private rvw jdField_a_of_type_Rvw;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private rld jdField_b_of_type_Rld;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private rld jdField_c_of_type_Rld;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public rvs(Activity paramActivity, FrameLayout paramFrameLayout, rvw paramrvw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Rvw = paramrvw;
    this.jdField_a_of_type_AndroidOsHandler = new blhq(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = ozs.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Odp = ((odp)paramActivity.a(90));
      this.jdField_a_of_type_Odq = new rvx(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.c();
    }
  }
  
  private void a(rld paramrld1, rld paramrld2)
  {
    if (((paramrld1 instanceof rwc)) && ((paramrld2 instanceof rwc)))
    {
      paramrld1 = (rwc)paramrld1;
      paramrld2 = (rwc)paramrld2;
    }
    try
    {
      paramrld2 = paramrld2.a;
      if (paramrld2 != null)
      {
        paramrld2.mChannelID = paramrld1.a.mChannelID;
        paramrld2.mRecommendTime = paramrld1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramrld1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramrld1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Odp != null) && (this.jdField_b_of_type_Rld != null)) {
      this.jdField_a_of_type_Odp.a(this.jdField_a_of_type_Odq, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Rld.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Odq != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Odq);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Rld.jdField_a_of_type_Int = (this.jdField_b_of_type_Rld.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Rld, this.jdField_c_of_type_Rld);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Rld != null) && (this.jdField_a_of_type_Rlq != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Rld);
      if (this.jdField_a_of_type_Rvv != null) {
        this.jdField_a_of_type_Rvv.a(this.jdField_b_of_type_Rld, this.jdField_c_of_type_Rld, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Rlq.a(this.jdField_c_of_type_Rld);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Rld = null;
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
        rvu localrvu = (rvu)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localrvu.jdField_a_of_type_Rld.a());
        localJSONObject2.put("playCount", localrvu.jdField_a_of_type_Int);
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
  
  public List<rvu> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public rld a()
  {
    return this.jdField_b_of_type_Rld;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Rld != null) {
      this.jdField_a_of_type_JavaUtilList.add(new rvu(this.jdField_b_of_type_Rld, this.jdField_d_of_type_Int));
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
    if (this.jdField_c_of_type_Rld != null)
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
  
  public void a(rld paramrld)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!bhnv.h(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramrld + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Odq != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Odq);
      }
      if ((paramrld != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Rld = paramrld;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramrld.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(tye.a(paramrld.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramrld = new sbg(null, null, paramrld.c, paramrld.a()).a((int)paramrld.jdField_b_of_type_Long).a().a();
      ocd.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramrld, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(rld paramrld, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramrld);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Rld = paramrld;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Rld != null)
    {
      if (paramrld.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramrld.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(rlq paramrlq)
  {
    this.jdField_a_of_type_Rlq = paramrlq;
  }
  
  public void a(rvv paramrvv)
  {
    this.jdField_a_of_type_Rvv = paramrvv;
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
  
  public void b(rld paramrld)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramrld);
    }
    this.jdField_c_of_type_Rld = paramrld;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramrld);
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
    this.jdField_a_of_type_Odp = null;
  }
  
  public void f()
  {
    rld localrld = (rld)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localrld == null)
    {
      g();
      return;
    }
    b(localrld);
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
      if (this.jdField_a_of_type_Rlq != null) {
        this.jdField_a_of_type_Rlq.a(this.jdField_a_of_type_Rld);
      }
      if (this.jdField_a_of_type_Rld != null)
      {
        String str = new sbg(null, null, this.jdField_a_of_type_Rld.c, this.jdField_a_of_type_Rld.a()).a((int)this.jdField_a_of_type_Rld.jdField_b_of_type_Long).a().a();
        ocd.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
        continue;
        if (this.jdField_a_of_type_Rvv != null)
        {
          this.jdField_a_of_type_Rvv.j();
          continue;
          if (this.jdField_c_of_type_Rld != null)
          {
            str = new sbg(null, null, this.jdField_c_of_type_Rld.c, this.jdField_c_of_type_Rld.a()).a((int)this.jdField_c_of_type_Rld.jdField_b_of_type_Long).i(this.jdField_c_of_type_Rld.a()).a().a();
            ocd.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
            b();
            j();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvs
 * JD-Core Version:    0.7.0.1
 */