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

public class qsq
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qsq.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private oqb jdField_a_of_type_Oqb;
  private qlp jdField_a_of_type_Qlp;
  private qsp jdField_a_of_type_Qsp;
  private boolean jdField_a_of_type_Boolean;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  
  public qsq(QQAppInterface paramQQAppInterface, Activity paramActivity, qlp paramqlp)
  {
    this.jdField_a_of_type_Qsp = new qsp(paramQQAppInterface);
    this.jdField_a_of_type_Int = baxn.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Qlp = paramqlp;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, qmp paramqmp, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramqmp.p == null) && ((paramqmp instanceof qmo)))
      {
        paramqmp.p = ((ViewGroup)((ViewStub)paramqmp.o.findViewById(2131378994)).inflate());
        paramqmp.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramqmp.p.findViewById(2131376125));
        paramqmp.G = ((TextView)paramqmp.p.findViewById(2131376126));
      }
      if (paramqmp.p != null)
      {
        paramqmp.p.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bbll.a(32.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bbll.a(32.0F);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(bavw.j);
        paramqmp.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        paramqmp.G.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        qoi.a(paramqmp.p, 200);
        paramqmp.p.setTag(paramqmp);
        paramqmp.p.setOnClickListener(this);
        nol.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new qzb(null, null, null, paramVideoInfo.g).R(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).h(paramVideoInfo.g).g(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
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
        if ((paramqmp.r == null) && (paramqmp.jdField_a_of_type_AndroidViewViewStub != null))
        {
          paramqmp.jdField_a_of_type_AndroidViewViewStub.inflate();
          paramqmp.r = ((ViewGroup)paramqmp.t.findViewById(2131372604));
          paramqmp.f = ((URLImageView)paramqmp.t.findViewById(2131376551));
          paramqmp.L = ((TextView)paramqmp.t.findViewById(2131376550));
          paramqmp.u = paramqmp.t.findViewById(2131376548);
          paramqmp.M = ((TextView)paramqmp.t.findViewById(2131376552));
          paramqmp.N = ((TextView)paramqmp.t.findViewById(2131376549));
          paramqmp.u.setTag(paramqmp);
          paramqmp.u.setOnClickListener(this);
          paramqmp.L.setTag(paramqmp);
          paramqmp.L.setOnClickListener(this);
        }
        qoi.a(paramqmp.r, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        paramqmp.f.setImageDrawable((Drawable)localObject2);
        int i;
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bbfr.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label591:
          if (i == 0) {
            break label666;
          }
          paramqmp.L.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramqmp.M.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramqmp.N.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramqmp.jdField_a_of_type_Qjo.a(false);
          paramqmp.jdField_a_of_type_Qjo.b(false);
          this.jdField_a_of_type_Qlp.f(false);
          break;
          i = 0;
          break label591;
          label666:
          paramqmp.L.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramqmp, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Qsp.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
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
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, qmp paramqmp, VideoInfo paramVideoInfo)
  {
    if ((paramqmp.s == null) && (paramqmp.b != null))
    {
      paramqmp.b.inflate();
      paramqmp.s = ((ViewGroup)paramqmp.t.findViewById(2131372600));
      paramqmp.O = ((TextView)paramqmp.s.findViewById(2131372601));
      paramqmp.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramqmp.s.findViewById(2131378976));
      int i = (int)(qoi.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramqmp.s.findViewById(2131378981).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Oqb = oqb.a("http://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramqmp.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new qsr(this, paramqmp));
      paramqmp.s.setOnClickListener(new qss(this));
    }
    this.jdField_a_of_type_Oqb.removeAllAnimatorListeners();
    this.jdField_a_of_type_Oqb.addAnimatorListener(new qst(this, paramqmp));
    paramqmp.s.setVisibility(8);
    qoi.a(paramqmp.s, 0);
    paramqmp.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Oqb);
    paramqmp.O.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Oqb.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qsp.a();
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
  
  public void a(VideoInfo paramVideoInfo, qmp paramqmp, int paramInt1, int paramInt2)
  {
    if (paramqmp.jdField_a_of_type_Int != 2) {}
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
              } while (paramqmp.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0);
              if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
                break;
              }
            } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
            a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramqmp, paramVideoInfo);
            this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
          return;
          if ((paramVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
          i = paramqmp.jdField_c_of_type_Int;
          if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) && (paramVideoInfo.c))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i + 1, true);
            return;
          }
        } while ((!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) || (this.jdField_a_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_b_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramqmp, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramqmp.p == null) || (paramqmp.p.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramqmp.p.setVisibility(8);
  }
  
  public void a(qmp paramqmp)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramqmp);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(qmp paramqmp)
  {
    if ((paramqmp == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramqmp.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramqmp.p == null);
      paramqmp.p.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramqmp.r != null) {
          paramqmp.r.setVisibility(8);
        }
        paramqmp.jdField_a_of_type_Qjo.a(true);
        paramqmp.jdField_a_of_type_Qjo.b(true);
        this.jdField_a_of_type_Qlp.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramqmp.s == null));
    qoi.a(paramqmp.s, 8);
  }
  
  public void c(qmp paramqmp)
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
        onh.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramqmp);
        if ((paramqmp == null) || (paramqmp.jdField_a_of_type_Qql == null)) {
          break label247;
        }
        paramqmp = paramqmp.jdField_a_of_type_Qql.a;
        if (paramqmp == null) {
          break label252;
        }
        localObject = paramqmp.g;
        label88:
        qzb localqzb = new qzb(null, null, null, (String)localObject).R(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramqmp == null) {
          break label257;
        }
        localObject = paramqmp.g;
        label139:
        localObject = localqzb.h((String)localObject);
        if (paramqmp == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paramqmp = Long.valueOf(paramqmp.f);; paramqmp = null)
    {
      nol.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((qzb)localObject).e(paramqmp.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      qoi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      qoi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label247:
      paramqmp = null;
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
    qmd localqmd = (qmd)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372603: 
    case 2131376550: 
      c((qmp)localqmd);
      return;
    }
    b((qmp)localqmd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsq
 * JD-Core Version:    0.7.0.1
 */