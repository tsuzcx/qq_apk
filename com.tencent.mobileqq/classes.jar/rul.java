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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class rul
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + rul.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pcs jdField_a_of_type_Pcs;
  private rnu jdField_a_of_type_Rnu;
  private ruk jdField_a_of_type_Ruk;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public rul(QQAppInterface paramQQAppInterface, Activity paramActivity, rnu paramrnu)
  {
    this.jdField_a_of_type_Ruk = new ruk(paramQQAppInterface);
    this.jdField_a_of_type_Int = rpt.a();
    this.jdField_b_of_type_Int = rpt.b();
    this.jdField_c_of_type_Int = rpt.c();
    this.jdField_a_of_type_Rnu = paramrnu;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rot paramrot, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramrot.jdField_r_of_type_AndroidViewViewGroup == null) && ((paramrot instanceof roq)))
      {
        paramrot.jdField_r_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)paramrot.q.findViewById(2131380851)).inflate());
        paramrot.e = ((URLImageView)paramrot.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131377640));
        paramrot.D = ((TextView)paramrot.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131377641));
        paramrot.t = paramrot.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131377639);
      }
      if (paramrot.jdField_r_of_type_AndroidViewViewGroup != null)
      {
        paramrot.jdField_r_of_type_AndroidViewViewGroup.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bhtq.a(this.jdField_c_of_type_Int);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bhtq.a(this.jdField_c_of_type_Int);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int });
        ((URLDrawable)localObject1).setDecodeHandler(bhez.k);
        paramrot.e.setImageDrawable((Drawable)localObject1);
        paramrot.D.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        rpt.a(paramrot.jdField_r_of_type_AndroidViewViewGroup, 200);
        paramrot.jdField_r_of_type_AndroidViewViewGroup.setTag(paramrot);
        paramrot.jdField_r_of_type_AndroidViewViewGroup.setOnClickListener(this);
        if (paramrot.t != null)
        {
          paramrot.t.setTag(paramrot);
          paramrot.t.setOnClickListener(this);
        }
        ocd.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new sbg(null, null, null, paramVideoInfo.g).P(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).i(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
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
        if ((paramrot.v == null) && (paramrot.jdField_b_of_type_AndroidViewViewStub != null))
        {
          paramrot.jdField_b_of_type_AndroidViewViewStub.inflate();
          paramrot.v = ((ViewGroup)paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131373731));
          paramrot.g = ((URLImageView)paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131378066));
          paramrot.I = ((TextView)paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131378065));
          paramrot.u = paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131378063);
          paramrot.J = ((TextView)paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131378067));
          paramrot.K = ((TextView)paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131378064));
          paramrot.u.setTag(paramrot);
          paramrot.u.setOnClickListener(this);
          paramrot.I.setTag(paramrot);
          paramrot.I.setOnClickListener(this);
        }
        rpt.a(paramrot.v, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        int i = bhtq.a(60.0F);
        int j = bhtq.a(10.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bhtq.a(i);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bhtq.a(i);
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(bhez.k);
        ((URLDrawable)localObject2).setTag(new int[] { 0, 0, j, 0 });
        paramrot.g.setImageDrawable((Drawable)localObject2);
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bhny.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label708:
          if (i == 0) {
            break label802;
          }
          paramrot.I.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramrot.J.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramrot.K.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramrot.z.setVisibility(8);
          paramrot.jdField_a_of_type_Rln.a(false);
          paramrot.jdField_a_of_type_Rln.b(false);
          paramrot.jdField_a_of_type_Rln.c(false);
          this.jdField_a_of_type_Rnu.f(false);
          break;
          i = 0;
          break label708;
          label802:
          paramrot.I.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramrot, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Ruk.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
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
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rot paramrot, VideoInfo paramVideoInfo)
  {
    if ((paramrot.w == null) && (paramrot.c != null))
    {
      paramrot.c.inflate();
      paramrot.w = ((ViewGroup)paramrot.jdField_r_of_type_AndroidViewView.findViewById(2131373727));
      paramrot.L = ((TextView)paramrot.w.findViewById(2131373728));
      paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramrot.w.findViewById(2131380830));
      int i = (int)(rpt.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramrot.w.findViewById(2131380838).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Pcs = pcs.a("https://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new rum(this, paramrot));
      paramrot.w.setOnClickListener(new run(this));
    }
    this.jdField_a_of_type_Pcs.removeAllAnimatorListeners();
    this.jdField_a_of_type_Pcs.addAnimatorListener(new ruo(this, paramrot));
    paramrot.w.setVisibility(8);
    rpt.a(paramrot.w, 0);
    paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Pcs);
    paramrot.L.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Pcs.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ruk.a();
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
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt)));
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rot paramrot, int paramInt1, int paramInt2)
  {
    if (paramrot.jdField_a_of_type_Int != 2) {}
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
          } while (paramrot.d.getVisibility() == 0);
          if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
        } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramrot, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramrot.jdField_r_of_type_AndroidViewViewGroup == null) || (paramrot.jdField_r_of_type_AndroidViewViewGroup.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrot.jdField_r_of_type_AndroidViewViewGroup.setVisibility(8);
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
  
  public void a(rot paramrot)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramrot);
  }
  
  public void b(rot paramrot)
  {
    if ((paramrot == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramrot.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramrot.jdField_r_of_type_AndroidViewViewGroup == null);
      paramrot.jdField_r_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramrot.v != null) {
          paramrot.v.setVisibility(8);
        }
        paramrot.z.setVisibility(0);
        paramrot.jdField_a_of_type_Rln.a(true);
        paramrot.jdField_a_of_type_Rln.b(true);
        paramrot.jdField_a_of_type_Rln.c(true);
        this.jdField_a_of_type_Rnu.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramrot.w == null));
    rpt.a(paramrot.w, 8);
  }
  
  public void c(rot paramrot)
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
        ozs.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramrot);
        if ((paramrot == null) || (paramrot.jdField_a_of_type_Rrm == null)) {
          break label247;
        }
        paramrot = paramrot.jdField_a_of_type_Rrm.a;
        if (paramrot == null) {
          break label252;
        }
        localObject = paramrot.g;
        label88:
        sbg localsbg = new sbg(null, null, null, (String)localObject).P(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramrot == null) {
          break label257;
        }
        localObject = paramrot.g;
        label139:
        localObject = localsbg.i((String)localObject);
        if (paramrot == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paramrot = Long.valueOf(paramrot.f);; paramrot = null)
    {
      ocd.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((sbg)localObject).e(paramrot.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      rpt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      rpt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label247:
      paramrot = null;
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
    roj localroj = (roj)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c((rot)localroj);
      continue;
      b((rot)localroj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rul
 * JD-Core Version:    0.7.0.1
 */