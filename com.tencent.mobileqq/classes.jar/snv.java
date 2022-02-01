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

public class snv
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + snv.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pta jdField_a_of_type_Pta;
  private shl jdField_a_of_type_Shl;
  private snu jdField_a_of_type_Snu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public snv(QQAppInterface paramQQAppInterface, Activity paramActivity, shl paramshl)
  {
    this.jdField_a_of_type_Snu = new snu(paramQQAppInterface);
    this.jdField_a_of_type_Int = six.a();
    this.jdField_b_of_type_Int = six.b();
    this.jdField_c_of_type_Int = six.c();
    this.jdField_a_of_type_Shl = paramshl;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, swu paramswu, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramswu.o == null) && ((paramswu instanceof swr)))
      {
        paramswu.o = ((ViewGroup)((ViewStub)paramswu.n.findViewById(2131380922)).inflate());
        paramswu.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramswu.o.findViewById(2131377681));
        paramswu.z = ((TextView)paramswu.o.findViewById(2131377682));
        paramswu.q = paramswu.o.findViewById(2131377680);
      }
      if (paramswu.o != null)
      {
        paramswu.o.setVisibility(0);
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
        ((URLDrawable)localObject1).setDecodeHandler(bgxc.k);
        paramswu.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        paramswu.z.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        six.a(paramswu.o, 200);
        paramswu.o.setTag(paramswu);
        paramswu.o.setOnClickListener(this);
        if (paramswu.q != null)
        {
          paramswu.q.setTag(paramswu);
          paramswu.q.setOnClickListener(this);
        }
        olh.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new suu(null, null, null, paramVideoInfo.g).P(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).i(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
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
        if ((paramswu.s == null) && (paramswu.jdField_a_of_type_AndroidViewViewStub != null))
        {
          paramswu.jdField_a_of_type_AndroidViewViewStub.inflate();
          paramswu.s = ((ViewGroup)paramswu.w.findViewById(2131373870));
          paramswu.f = ((URLImageView)paramswu.w.findViewById(2131378118));
          paramswu.E = ((TextView)paramswu.w.findViewById(2131378117));
          paramswu.r = paramswu.w.findViewById(2131378115);
          paramswu.F = ((TextView)paramswu.w.findViewById(2131378119));
          paramswu.G = ((TextView)paramswu.w.findViewById(2131378116));
          paramswu.r.setTag(paramswu);
          paramswu.r.setOnClickListener(this);
          paramswu.E.setTag(paramswu);
          paramswu.E.setOnClickListener(this);
        }
        six.a(paramswu.s, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        int i = ViewUtils.dip2px(60.0F);
        int j = ViewUtils.dip2px(10.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.dip2px(i);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.dip2px(i);
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(bgxc.k);
        ((URLDrawable)localObject2).setTag(new int[] { 0, 0, j, 0 });
        paramswu.f.setImageDrawable((Drawable)localObject2);
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bhfn.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label708:
          if (i == 0) {
            break label802;
          }
          paramswu.E.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramswu.F.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramswu.G.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramswu.v.setVisibility(8);
          paramswu.jdField_a_of_type_Sfc.a(false);
          paramswu.jdField_a_of_type_Sfc.b(false);
          paramswu.jdField_a_of_type_Sfc.c(false);
          this.jdField_a_of_type_Shl.f(false);
          break;
          i = 0;
          break label708;
          label802:
          paramswu.E.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramswu, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Snu.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
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
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, swu paramswu, VideoInfo paramVideoInfo)
  {
    if ((paramswu.t == null) && (paramswu.b != null))
    {
      paramswu.b.inflate();
      paramswu.t = ((ViewGroup)paramswu.w.findViewById(2131373866));
      paramswu.H = ((TextView)paramswu.t.findViewById(2131373867));
      paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramswu.t.findViewById(2131380900));
      int i = (int)(six.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramswu.t.findViewById(2131380908).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Pta = pta.a("https://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new snw(this, paramswu));
      paramswu.t.setOnClickListener(new snx(this));
    }
    this.jdField_a_of_type_Pta.removeAllAnimatorListeners();
    this.jdField_a_of_type_Pta.addAnimatorListener(new sny(this, paramswu));
    paramswu.t.setVisibility(8);
    six.a(paramswu.t, 0);
    paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Pta);
    paramswu.H.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Pta.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Snu.a();
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
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(six.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt)));
    }
  }
  
  public void a(VideoInfo paramVideoInfo, swu paramswu, int paramInt1, int paramInt2)
  {
    if (paramswu.jdField_a_of_type_Int != 2) {}
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
          } while (paramswu.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0);
          if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
        } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramswu, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramswu.o == null) || (paramswu.o.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramswu.o.setVisibility(8);
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
  
  public void a(swu paramswu)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramswu);
  }
  
  public void b(swu paramswu)
  {
    if ((paramswu == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramswu.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramswu.o == null);
      paramswu.o.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramswu.s != null) {
          paramswu.s.setVisibility(8);
        }
        paramswu.v.setVisibility(0);
        paramswu.jdField_a_of_type_Sfc.a(true);
        paramswu.jdField_a_of_type_Sfc.b(true);
        paramswu.jdField_a_of_type_Sfc.c(true);
        this.jdField_a_of_type_Shl.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramswu.t == null));
    six.a(paramswu.t, 8);
  }
  
  public void c(swu paramswu)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    label80:
    Object localObject;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 0) {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e))
      {
        pkh.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramswu);
        if ((paramswu == null) || (paramswu.jdField_a_of_type_Skq == null)) {
          break label248;
        }
        paramswu = paramswu.jdField_a_of_type_Skq.a;
        if (paramswu == null) {
          break label253;
        }
        localObject = paramswu.g;
        label89:
        suu localsuu = new suu(null, null, null, (String)localObject).P(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramswu == null) {
          break label258;
        }
        localObject = paramswu.g;
        label140:
        localObject = localsuu.i((String)localObject);
        if (paramswu == null) {
          break label263;
        }
      }
    }
    label258:
    label263:
    for (paramswu = Long.valueOf(paramswu.f);; paramswu = null)
    {
      olh.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((suu)localObject).e(paramswu.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      six.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      six.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label248:
      paramswu = null;
      break label80;
      label253:
      localObject = null;
      break label89;
      localObject = null;
      break label140;
    }
  }
  
  public void onClick(View paramView)
  {
    swj localswj = (swj)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c((swu)localswj);
      continue;
      b((swu)localswj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snv
 * JD-Core Version:    0.7.0.1
 */