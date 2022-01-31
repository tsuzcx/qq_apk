import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class qji
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<qjk> jdField_a_of_type_JavaUtilArrayList;
  private qmd jdField_a_of_type_Qmd;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public qji(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    int i = 2;
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (qls.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bbfd.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(qqo paramqqo)
  {
    return (paramqqo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqqo.jdField_a_of_type_Qbw != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.j != null))
    {
      localResources = this.jdField_a_of_type_Qmd.j.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo == null) || (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130842510;
        if (localResources.getText(2131718451).toString().equals(localObject1)) {
          i = 2130842509;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Qmd.j.setText((CharSequence)localObject1);
      int j = actn.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Qmd.j.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131718456).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718451).toString();
      break;
      localObject1 = localResources.getText(2131718453).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718494).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131718494).toString();
      break;
      if (localResources.getText(2131718453).toString().equals(localObject1)) {
        i = 2130842512;
      }
    }
  }
  
  public qmd a()
  {
    return this.jdField_a_of_type_Qmd;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_Qmd != null) {
      this.jdField_a_of_type_Qmd = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(qjk paramqjk)
  {
    if ((paramqjk != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramqjk))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramqjk);
    }
  }
  
  public void a(qms paramqms)
  {
    if (this.jdField_a_of_type_Qmd != null)
    {
      this.jdField_a_of_type_Qmd.g.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramqms instanceof qmd))
    {
      this.jdField_a_of_type_Qmd = ((qmd)paramqms);
      return;
    }
    this.jdField_a_of_type_Qmd = null;
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.g != null) && (this.jdField_a_of_type_Qmd.g.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Qmd.g.setVisibility(8);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(qqo paramqqo)
  {
    if ((paramqqo == null) || (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Qmd != null) && (!this.jdField_a_of_type_Boolean) && (oat.b(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Qmd == null) || (this.jdField_a_of_type_Boolean) || (!oat.a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    qbw localqbw;
    boolean bool;
    label163:
    AdvertisementInfo localAdvertisementInfo;
    int m;
    int n;
    int i;
    label228:
    int j;
    label238:
    int i1;
    if ((b(paramqqo)) && (paramqqo.jdField_a_of_type_Qub != null) && (!paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Boolean))
    {
      if (paramqqo.jdField_a_of_type_Qub.e() != 0L) {
        break label496;
      }
      paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int = paramqqo.jdField_a_of_type_Qbw.e;
      paramqqo.jdField_a_of_type_Qbw.e = ((int)paramqqo.jdField_a_of_type_Qub.b(true));
      localqbw = paramqqo.jdField_a_of_type_Qbw;
      if (paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localqbw.b = bool;
      paramqqo.jdField_a_of_type_Qbw.c = true;
      paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Boolean = true;
      localqbw = paramqqo.jdField_a_of_type_Qbw;
      localAdvertisementInfo = nmf.a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localqbw.jdField_d_of_type_Int;
      n = localqbw.e;
      if (!localqbw.b) {
        break label520;
      }
      i = 1;
      if (!localqbw.c) {
        break label525;
      }
      j = 1;
      i1 = localqbw.f;
      if (!localqbw.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = nmf.a(m, n, i, j, i1, k, (int)paramqqo.jdField_a_of_type_Qub.b(), nmf.aE, 0);
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.f).b(localqbw.g).a(localAdvertisementInfo).a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Qmd.g != null)
      {
        this.jdField_a_of_type_Qmd.g.setVisibility(0);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a("continue_pause", true);
        if (this.jdField_a_of_type_Qmd.h != null) {
          this.jdField_a_of_type_Qmd.h.setVisibility(8);
        }
        paramqqo = ObjectAnimator.ofFloat(this.jdField_a_of_type_Qmd.g, "alpha", new float[] { 0.0F, 1.0F });
        paramqqo.setDuration(200L);
        paramqqo.setInterpolator(new DecelerateInterpolator());
        paramqqo.addListener(new qjj(this));
        paramqqo.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int = ((int)paramqqo.jdField_a_of_type_Qub.e());
      break;
      bool = false;
      break label163;
      i = 0;
      break label228;
      j = 0;
      break label238;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.b = true;
    b();
  }
  
  public void d()
  {
    this.b = false;
    a();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.g != null))
    {
      this.jdField_a_of_type_Qmd.g.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
      this.c = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Qmd.g != null)
      {
        this.jdField_a_of_type_Qmd.g.setVisibility(8);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((qjk)paramMessage.next()).a();
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return true;
      label154:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qji
 * JD-Core Version:    0.7.0.1
 */