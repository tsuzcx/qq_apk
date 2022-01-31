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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ric
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + ric.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private out jdField_a_of_type_Out;
  private raw jdField_a_of_type_Raw;
  private rib jdField_a_of_type_Rib;
  private boolean jdField_a_of_type_Boolean;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  
  public ric(QQAppInterface paramQQAppInterface, Activity paramActivity, raw paramraw)
  {
    this.jdField_a_of_type_Rib = new rib(paramQQAppInterface);
    this.jdField_a_of_type_Int = bcwh.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Raw = paramraw;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rbt paramrbt, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramrbt.q == null) && ((paramrbt instanceof rbs)))
      {
        paramrbt.q = ((ViewGroup)((ViewStub)paramrbt.p.findViewById(2131379658)).inflate());
        paramrbt.e = ((URLImageView)paramrbt.q.findViewById(2131376625));
        paramrbt.G = ((TextView)paramrbt.q.findViewById(2131376626));
      }
      if (paramrbt.q != null)
      {
        paramrbt.q.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bdkf.a(32.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bdkf.a(32.0F);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(bcuq.j);
        paramrbt.e.setImageDrawable((Drawable)localObject1);
        paramrbt.G.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        rdm.a(paramrbt.q, 200);
        paramrbt.q.setTag(paramrbt);
        paramrbt.q.setOnClickListener(this);
        nrt.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new ron(null, null, null, paramVideoInfo.g).Q(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).h(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
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
        if ((paramrbt.s == null) && (paramrbt.jdField_a_of_type_AndroidViewViewStub != null))
        {
          paramrbt.jdField_a_of_type_AndroidViewViewStub.inflate();
          paramrbt.s = ((ViewGroup)paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131372961));
          paramrbt.g = ((URLImageView)paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131377051));
          paramrbt.L = ((TextView)paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131377050));
          paramrbt.u = paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131377048);
          paramrbt.M = ((TextView)paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131377052));
          paramrbt.N = ((TextView)paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131377049));
          paramrbt.u.setTag(paramrbt);
          paramrbt.u.setOnClickListener(this);
          paramrbt.L.setTag(paramrbt);
          paramrbt.L.setOnClickListener(this);
        }
        rdm.a(paramrbt.s, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        paramrbt.g.setImageDrawable((Drawable)localObject2);
        int i;
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bdem.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label591:
          if (i == 0) {
            break label666;
          }
          paramrbt.L.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramrbt.M.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramrbt.N.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramrbt.jdField_a_of_type_Qyv.a(false);
          paramrbt.jdField_a_of_type_Qyv.b(false);
          this.jdField_a_of_type_Raw.f(false);
          break;
          i = 0;
          break label591;
          label666:
          paramrbt.L.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramrbt, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Rib.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
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
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, rbt paramrbt, VideoInfo paramVideoInfo)
  {
    if ((paramrbt.jdField_t_of_type_AndroidViewViewGroup == null) && (paramrbt.b != null))
    {
      paramrbt.b.inflate();
      paramrbt.jdField_t_of_type_AndroidViewViewGroup = ((ViewGroup)paramrbt.jdField_t_of_type_AndroidViewView.findViewById(2131372957));
      paramrbt.O = ((TextView)paramrbt.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131372958));
      paramrbt.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramrbt.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131379634));
      int i = (int)(rdm.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramrbt.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131379640).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Out = out.a("http://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramrbt.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new rid(this, paramrbt));
      paramrbt.jdField_t_of_type_AndroidViewViewGroup.setOnClickListener(new rie(this));
    }
    this.jdField_a_of_type_Out.removeAllAnimatorListeners();
    this.jdField_a_of_type_Out.addAnimatorListener(new rif(this, paramrbt));
    paramrbt.jdField_t_of_type_AndroidViewViewGroup.setVisibility(8);
    rdm.a(paramrbt.jdField_t_of_type_AndroidViewViewGroup, 0);
    paramrbt.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Out);
    paramrbt.O.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Out.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rib.a();
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
  
  public void a(VideoInfo paramVideoInfo, rbt paramrbt, int paramInt1, int paramInt2)
  {
    if (paramrbt.jdField_a_of_type_Int != 2) {}
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
              } while (paramrbt.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0);
              if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
                break;
              }
            } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
            a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramrbt, paramVideoInfo);
            this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
          return;
          if ((paramVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
          i = paramrbt.jdField_c_of_type_Int;
          if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) && (paramVideoInfo.c))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i + 1, true);
            return;
          }
        } while ((!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) || (this.jdField_a_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_b_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramrbt, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramrbt.q == null) || (paramrbt.q.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrbt.q.setVisibility(8);
  }
  
  public void a(rbt paramrbt)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramrbt);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(rbt paramrbt)
  {
    if ((paramrbt == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramrbt.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramrbt.q == null);
      paramrbt.q.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramrbt.s != null) {
          paramrbt.s.setVisibility(8);
        }
        paramrbt.jdField_a_of_type_Qyv.a(true);
        paramrbt.jdField_a_of_type_Qyv.b(true);
        this.jdField_a_of_type_Raw.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramrbt.jdField_t_of_type_AndroidViewViewGroup == null));
    rdm.a(paramrbt.jdField_t_of_type_AndroidViewViewGroup, 8);
  }
  
  public void c(rbt paramrbt)
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
        ors.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramrbt);
        if ((paramrbt == null) || (paramrbt.jdField_a_of_type_Rfs == null)) {
          break label247;
        }
        paramrbt = paramrbt.jdField_a_of_type_Rfs.a;
        if (paramrbt == null) {
          break label252;
        }
        localObject = paramrbt.g;
        label88:
        ron localron = new ron(null, null, null, (String)localObject).Q(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramrbt == null) {
          break label257;
        }
        localObject = paramrbt.g;
        label139:
        localObject = localron.h((String)localObject);
        if (paramrbt == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paramrbt = Long.valueOf(paramrbt.f);; paramrbt = null)
    {
      nrt.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((ron)localObject).e(paramrbt.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      rdm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      rdm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label247:
      paramrbt = null;
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
    rbl localrbl = (rbl)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372960: 
    case 2131377050: 
      c((rbt)localrbl);
      return;
    }
    b((rbt)localrbl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ric
 * JD-Core Version:    0.7.0.1
 */