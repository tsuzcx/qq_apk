import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class sdq
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + sdq.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pka jdField_a_of_type_Pka;
  private rwy jdField_a_of_type_Rwy;
  private sdp jdField_a_of_type_Sdp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public sdq(QQAppInterface paramQQAppInterface, Activity paramActivity, rwy paramrwy)
  {
    this.jdField_a_of_type_Sdp = new sdp(paramQQAppInterface);
    this.jdField_a_of_type_Int = ryx.a();
    this.jdField_b_of_type_Int = ryx.b();
    this.jdField_c_of_type_Int = ryx.c();
    this.jdField_a_of_type_Rwy = paramrwy;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rxy paramrxy, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramrxy.s == null) && ((paramrxy instanceof rxv)))
      {
        paramrxy.s = ((ViewGroup)((ViewStub)paramrxy.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131380673)).inflate());
        paramrxy.e = ((URLImageView)paramrxy.s.findViewById(2131377486));
        paramrxy.D = ((TextView)paramrxy.s.findViewById(2131377487));
        paramrxy.t = paramrxy.s.findViewById(2131377485);
      }
      if (paramrxy.s != null)
      {
        paramrxy.s.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bgtn.a(this.jdField_c_of_type_Int);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bgtn.a(this.jdField_c_of_type_Int);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int });
        ((URLDrawable)localObject1).setDecodeHandler(bgey.k);
        paramrxy.e.setImageDrawable((Drawable)localObject1);
        paramrxy.D.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        ryx.a(paramrxy.s, 200);
        paramrxy.s.setTag(paramrxy);
        paramrxy.s.setOnClickListener(this);
        if (paramrxy.t != null)
        {
          paramrxy.t.setTag(paramrxy);
          paramrxy.t.setOnClickListener(this);
        }
        oat.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new skc(null, null, null, paramVideoInfo.g).Q(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).h(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
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
        if ((paramrxy.w == null) && (paramrxy.jdField_b_of_type_AndroidViewViewStub != null))
        {
          paramrxy.jdField_b_of_type_AndroidViewViewStub.inflate();
          paramrxy.w = ((ViewGroup)paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131373612));
          paramrxy.g = ((URLImageView)paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131377912));
          paramrxy.I = ((TextView)paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131377911));
          paramrxy.u = paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131377909);
          paramrxy.J = ((TextView)paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131377913));
          paramrxy.K = ((TextView)paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131377910));
          paramrxy.u.setTag(paramrxy);
          paramrxy.u.setOnClickListener(this);
          paramrxy.I.setTag(paramrxy);
          paramrxy.I.setOnClickListener(this);
        }
        ryx.a(paramrxy.w, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        int i = bgtn.a(60.0F);
        int j = bgtn.a(10.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bgtn.a(i);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bgtn.a(i);
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(bgey.k);
        ((URLDrawable)localObject2).setTag(new int[] { 0, 0, j, 0 });
        paramrxy.g.setImageDrawable((Drawable)localObject2);
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bgnw.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label708:
          if (i == 0) {
            break label802;
          }
          paramrxy.I.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramrxy.J.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramrxy.K.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramrxy.z.setVisibility(8);
          paramrxy.jdField_a_of_type_Rur.a(false);
          paramrxy.jdField_a_of_type_Rur.b(false);
          paramrxy.jdField_a_of_type_Rur.c(false);
          this.jdField_a_of_type_Rwy.f(false);
          break;
          i = 0;
          break label708;
          label802:
          paramrxy.I.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramrxy, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Sdp.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
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
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rxy paramrxy, VideoInfo paramVideoInfo)
  {
    if ((paramrxy.x == null) && (paramrxy.jdField_c_of_type_AndroidViewViewStub != null))
    {
      paramrxy.jdField_c_of_type_AndroidViewViewStub.inflate();
      paramrxy.x = ((ViewGroup)paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131373608));
      paramrxy.L = ((TextView)paramrxy.x.findViewById(2131373609));
      paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramrxy.x.findViewById(2131380646));
      int i = (int)(ryx.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramrxy.x.findViewById(2131380655).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Pka = pka.a("https://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new sdr(this, paramrxy));
      paramrxy.x.setOnClickListener(new sds(this));
    }
    this.jdField_a_of_type_Pka.removeAllAnimatorListeners();
    this.jdField_a_of_type_Pka.addAnimatorListener(new sdt(this, paramrxy));
    paramrxy.x.setVisibility(8);
    ryx.a(paramrxy.x, 0);
    paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Pka);
    paramrxy.L.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Pka.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Sdp.a();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    }
    if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "play by positions, position to play is: " + Arrays.toString(paramECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt) + ", play time is:" + paramECommerceEntranceInfo.jdField_b_of_type_Int + ", play percent :" + paramECommerceEntranceInfo.jdField_c_of_type_Int);
      }
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt.length)
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt[i] - 1, true);
          i += 1;
        }
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rxy paramrxy, int paramInt1, int paramInt2)
  {
    if (paramrxy.jdField_a_of_type_Int != 2) {}
    label8:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              break label8;
              break label8;
              break label8;
              do
              {
                return;
              } while (paramrxy.d.getVisibility() == 0);
              if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
                break;
              }
            } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
            a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramrxy, paramVideoInfo);
            this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
          return;
          if ((paramVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
          i = paramrxy.jdField_c_of_type_Int;
          if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) && (paramVideoInfo.c))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i + 1, true);
            return;
          }
        } while ((!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) || (this.jdField_a_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_b_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramrxy, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramrxy.s == null) || (paramrxy.s.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrxy.s.setVisibility(8);
  }
  
  public void a(rxy paramrxy)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramrxy);
  }
  
  public void b(rxy paramrxy)
  {
    if ((paramrxy == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramrxy.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramrxy.s == null);
      paramrxy.s.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramrxy.w != null) {
          paramrxy.w.setVisibility(8);
        }
        paramrxy.z.setVisibility(0);
        paramrxy.jdField_a_of_type_Rur.a(true);
        paramrxy.jdField_a_of_type_Rur.b(true);
        paramrxy.jdField_a_of_type_Rur.c(true);
        this.jdField_a_of_type_Rwy.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramrxy.x == null));
    ryx.a(paramrxy.x, 8);
  }
  
  public void c(rxy paramrxy)
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
        pha.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramrxy);
        if ((paramrxy == null) || (paramrxy.jdField_a_of_type_Sar == null)) {
          break label247;
        }
        paramrxy = paramrxy.jdField_a_of_type_Sar.a;
        if (paramrxy == null) {
          break label252;
        }
        localObject = paramrxy.g;
        label88:
        skc localskc = new skc(null, null, null, (String)localObject).Q(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramrxy == null) {
          break label257;
        }
        localObject = paramrxy.g;
        label139:
        localObject = localskc.h((String)localObject);
        if (paramrxy == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paramrxy = Long.valueOf(paramrxy.f);; paramrxy = null)
    {
      oat.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((skc)localObject).e(paramrxy.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      ryx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      ryx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label247:
      paramrxy = null;
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
    rxo localrxo = (rxo)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c((rxy)localrxo);
      continue;
      b((rxy)localrxo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdq
 * JD-Core Version:    0.7.0.1
 */