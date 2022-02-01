import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class sbp
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + sbp.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pid jdField_a_of_type_Pid;
  private ruw jdField_a_of_type_Ruw;
  private sbo jdField_a_of_type_Sbo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public sbp(QQAppInterface paramQQAppInterface, Activity paramActivity, ruw paramruw)
  {
    this.jdField_a_of_type_Sbo = new sbo(paramQQAppInterface);
    this.jdField_a_of_type_Int = rwv.a();
    this.jdField_b_of_type_Int = rwv.b();
    this.jdField_c_of_type_Int = rwv.c();
    this.jdField_a_of_type_Ruw = paramruw;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rvv paramrvv, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramrvv.s == null) && ((paramrvv instanceof rvs)))
      {
        paramrvv.s = ((ViewGroup)((ViewStub)paramrvv.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131380577)).inflate());
        paramrvv.e = ((URLImageView)paramrvv.s.findViewById(2131377408));
        paramrvv.D = ((TextView)paramrvv.s.findViewById(2131377409));
        paramrvv.t = paramrvv.s.findViewById(2131377407);
      }
      if (paramrvv.s != null)
      {
        paramrvv.s.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ViewUtils.dip2px(this.jdField_c_of_type_Int);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ViewUtils.dip2px(this.jdField_c_of_type_Int);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int });
        ((URLDrawable)localObject1).setDecodeHandler(bfol.k);
        paramrvv.e.setImageDrawable((Drawable)localObject1);
        paramrvv.D.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        rwv.a(paramrvv.s, 200);
        paramrvv.s.setTag(paramrvv);
        paramrvv.s.setOnClickListener(this);
        if (paramrvv.t != null)
        {
          paramrvv.t.setTag(paramrvv);
          paramrvv.t.setOnClickListener(this);
        }
        odq.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new sie(null, null, null, paramVideoInfo.g).P(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).i(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString);
        continue;
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if ((paramrvv.w == null) && (paramrvv.jdField_b_of_type_AndroidViewViewStub != null))
        {
          paramrvv.jdField_b_of_type_AndroidViewViewStub.inflate();
          paramrvv.w = ((ViewGroup)paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131373653));
          paramrvv.g = ((URLImageView)paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131377836));
          paramrvv.I = ((TextView)paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131377835));
          paramrvv.u = paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131377833);
          paramrvv.J = ((TextView)paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131377837));
          paramrvv.K = ((TextView)paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131377834));
          paramrvv.u.setTag(paramrvv);
          paramrvv.u.setOnClickListener(this);
          paramrvv.I.setTag(paramrvv);
          paramrvv.I.setOnClickListener(this);
        }
        rwv.a(paramrvv.w, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        int i = ViewUtils.dip2px(60.0F);
        int j = ViewUtils.dip2px(10.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.dip2px(i);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.dip2px(i);
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(bfol.k);
        ((URLDrawable)localObject2).setTag(new int[] { 0, 0, j, 0 });
        paramrvv.g.setImageDrawable((Drawable)localObject2);
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bfwv.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label708:
          if (i == 0) {
            break label802;
          }
          paramrvv.I.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramrvv.J.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramrvv.K.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramrvv.z.setVisibility(8);
          paramrvv.jdField_a_of_type_Rsn.a(false);
          paramrvv.jdField_a_of_type_Rsn.b(false);
          paramrvv.jdField_a_of_type_Rsn.c(false);
          this.jdField_a_of_type_Ruw.f(false);
          break;
          i = 0;
          break label708;
          label802:
          paramrvv.I.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramrvv, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Sbo.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, int paramInt1, int paramInt2)
  {
    if ((paramECommerceEntranceInfo.jdField_b_of_type_Int >= 0) && (paramInt1 >= paramECommerceEntranceInfo.jdField_b_of_type_Int)) {}
    while ((paramECommerceEntranceInfo.jdField_c_of_type_Int >= 0) && (paramInt1 / paramInt2 * 100.0F >= paramECommerceEntranceInfo.jdField_c_of_type_Int)) {
      return true;
    }
    return false;
  }
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rvv paramrvv, VideoInfo paramVideoInfo)
  {
    if ((paramrvv.x == null) && (paramrvv.c != null))
    {
      paramrvv.c.inflate();
      paramrvv.x = ((ViewGroup)paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131373649));
      paramrvv.L = ((TextView)paramrvv.x.findViewById(2131373650));
      paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramrvv.x.findViewById(2131380556));
      int i = (int)(rwv.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramrvv.x.findViewById(2131380564).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Pid = pid.a("https://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new sbq(this, paramrvv));
      paramrvv.x.setOnClickListener(new sbr(this));
    }
    this.jdField_a_of_type_Pid.removeAllAnimatorListeners();
    this.jdField_a_of_type_Pid.addAnimatorListener(new sbs(this, paramrvv));
    paramrvv.x.setVisibility(8);
    rwv.a(paramrvv.x, 0);
    paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Pid);
    paramrvv.L.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Pid.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Sbo.a();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) && (paramECommerceEntranceInfo != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "play by positions, position to play is: " + Arrays.toString(paramECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt) + ", play time is:" + paramECommerceEntranceInfo.jdField_b_of_type_Int + ", play percent :" + paramECommerceEntranceInfo.jdField_c_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(rwv.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt)));
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rvv paramrvv, int paramInt1, int paramInt2)
  {
    if (paramrvv.jdField_a_of_type_Int != 2) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (paramrvv.d.getVisibility() == 0);
          if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
        } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramrvv, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramrvv.s == null) || (paramrvv.s.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrvv.s.setVisibility(8);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        int i = localInteger.intValue() - 1;
        if ((i > 0) && (i < paramList.size()))
        {
          VideoInfo localVideoInfo2 = (VideoInfo)paramList.get(i);
          VideoInfo localVideoInfo1 = localVideoInfo2;
          if (localVideoInfo2.c)
          {
            if (i + 1 < paramList.size()) {
              localVideoInfo1 = (VideoInfo)paramList.get(i + 1);
            }
          }
          else
          {
            if (localVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
              localVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(localInteger);
          }
        }
      }
    }
  }
  
  public void a(rvv paramrvv)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramrvv);
  }
  
  public void b(rvv paramrvv)
  {
    if ((paramrvv == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramrvv.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramrvv.s == null);
      paramrvv.s.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramrvv.w != null) {
          paramrvv.w.setVisibility(8);
        }
        paramrvv.z.setVisibility(0);
        paramrvv.jdField_a_of_type_Rsn.a(true);
        paramrvv.jdField_a_of_type_Rsn.b(true);
        paramrvv.jdField_a_of_type_Rsn.c(true);
        this.jdField_a_of_type_Ruw.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramrvv.x == null));
    rwv.a(paramrvv.x, 8);
  }
  
  public void c(rvv paramrvv)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    label79:
    Object localObject;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 0) {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e))
      {
        pay.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramrvv);
        if ((paramrvv == null) || (paramrvv.jdField_a_of_type_Ryo == null)) {
          break label247;
        }
        paramrvv = paramrvv.jdField_a_of_type_Ryo.a;
        if (paramrvv == null) {
          break label252;
        }
        localObject = paramrvv.g;
        label88:
        sie localsie = new sie(null, null, null, (String)localObject).P(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramrvv == null) {
          break label257;
        }
        localObject = paramrvv.g;
        label139:
        localObject = localsie.i((String)localObject);
        if (paramrvv == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paramrvv = Long.valueOf(paramrvv.f);; paramrvv = null)
    {
      odq.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((sie)localObject).e(paramrvv.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      rwv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      rwv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label247:
      paramrvv = null;
      break label79;
      label252:
      localObject = null;
      break label88;
      localObject = null;
      break label139;
    }
  }
  
  public void onClick(View paramView)
  {
    rvl localrvl = (rvl)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c((rvv)localrvl);
      continue;
      b((rvv)localrvl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbp
 * JD-Core Version:    0.7.0.1
 */