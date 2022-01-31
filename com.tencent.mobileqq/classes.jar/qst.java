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

public class qst
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qst.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private oqe jdField_a_of_type_Oqe;
  private qls jdField_a_of_type_Qls;
  private qss jdField_a_of_type_Qss;
  private boolean jdField_a_of_type_Boolean;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  
  public qst(QQAppInterface paramQQAppInterface, Activity paramActivity, qls paramqls)
  {
    this.jdField_a_of_type_Qss = new qss(paramQQAppInterface);
    this.jdField_a_of_type_Int = bawz.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Qls = paramqls;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, qms paramqms, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramqms.p == null) && ((paramqms instanceof qmr)))
      {
        paramqms.p = ((ViewGroup)((ViewStub)paramqms.o.findViewById(2131378989)).inflate());
        paramqms.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramqms.p.findViewById(2131376123));
        paramqms.G = ((TextView)paramqms.p.findViewById(2131376124));
      }
      if (paramqms.p != null)
      {
        paramqms.p.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bbkx.a(32.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bbkx.a(32.0F);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(bavi.j);
        paramqms.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        paramqms.G.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        qol.a(paramqms.p, 200);
        paramqms.p.setTag(paramqms);
        paramqms.p.setOnClickListener(this);
        noo.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new qze(null, null, null, paramVideoInfo.g).R(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).h(paramVideoInfo.g).g(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
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
        if ((paramqms.r == null) && (paramqms.jdField_a_of_type_AndroidViewViewStub != null))
        {
          paramqms.jdField_a_of_type_AndroidViewViewStub.inflate();
          paramqms.r = ((ViewGroup)paramqms.t.findViewById(2131372602));
          paramqms.f = ((URLImageView)paramqms.t.findViewById(2131376549));
          paramqms.L = ((TextView)paramqms.t.findViewById(2131376548));
          paramqms.u = paramqms.t.findViewById(2131376546);
          paramqms.M = ((TextView)paramqms.t.findViewById(2131376550));
          paramqms.N = ((TextView)paramqms.t.findViewById(2131376547));
          paramqms.u.setTag(paramqms);
          paramqms.u.setOnClickListener(this);
          paramqms.L.setTag(paramqms);
          paramqms.L.setOnClickListener(this);
        }
        qol.a(paramqms.r, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        paramqms.f.setImageDrawable((Drawable)localObject2);
        int i;
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bbfd.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label591:
          if (i == 0) {
            break label666;
          }
          paramqms.L.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramqms.M.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramqms.N.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramqms.jdField_a_of_type_Qjr.a(false);
          paramqms.jdField_a_of_type_Qjr.b(false);
          this.jdField_a_of_type_Qls.f(false);
          break;
          i = 0;
          break label591;
          label666:
          paramqms.L.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramqms, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_Qss.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
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
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, qms paramqms, VideoInfo paramVideoInfo)
  {
    if ((paramqms.s == null) && (paramqms.b != null))
    {
      paramqms.b.inflate();
      paramqms.s = ((ViewGroup)paramqms.t.findViewById(2131372598));
      paramqms.O = ((TextView)paramqms.s.findViewById(2131372599));
      paramqms.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramqms.s.findViewById(2131378971));
      int i = (int)(qol.b(this.jdField_a_of_type_AndroidAppActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paramqms.s.findViewById(2131378976).getLayoutParams()).topMargin = i;
      this.jdField_a_of_type_Oqe = oqe.a("http://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paramqms.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibilityChangedListener(new qsu(this, paramqms));
      paramqms.s.setOnClickListener(new qsv(this));
    }
    this.jdField_a_of_type_Oqe.removeAllAnimatorListeners();
    this.jdField_a_of_type_Oqe.addAnimatorListener(new qsw(this, paramqms));
    paramqms.s.setVisibility(8);
    qol.a(paramqms.s, 0);
    paramqms.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(this.jdField_a_of_type_Oqe);
    paramqms.O.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Oqe.playAnimation();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qss.a();
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
  
  public void a(VideoInfo paramVideoInfo, qms paramqms, int paramInt1, int paramInt2)
  {
    if (paramqms.jdField_a_of_type_Int != 2) {}
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
              } while (paramqms.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0);
              if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
                break;
              }
            } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
            a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramqms, paramVideoInfo);
            this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
          return;
          if ((paramVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
          i = paramqms.jdField_c_of_type_Int;
          if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) && (paramVideoInfo.c))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i + 1, true);
            return;
          }
        } while ((!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) || (this.jdField_a_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_b_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramqms, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramqms.p == null) || (paramqms.p.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramqms.p.setVisibility(8);
  }
  
  public void a(qms paramqms)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramqms);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(qms paramqms)
  {
    if ((paramqms == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramqms.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramqms.p == null);
      paramqms.p.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramqms.r != null) {
          paramqms.r.setVisibility(8);
        }
        paramqms.jdField_a_of_type_Qjr.a(true);
        paramqms.jdField_a_of_type_Qjr.b(true);
        this.jdField_a_of_type_Qls.f(true);
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2) || (paramqms.s == null));
    qol.a(paramqms.s, 8);
  }
  
  public void c(qms paramqms)
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
        onk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramqms);
        if ((paramqms == null) || (paramqms.jdField_a_of_type_Qqo == null)) {
          break label247;
        }
        paramqms = paramqms.jdField_a_of_type_Qqo.a;
        if (paramqms == null) {
          break label252;
        }
        localObject = paramqms.g;
        label88:
        qze localqze = new qze(null, null, null, (String)localObject).R(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramqms == null) {
          break label257;
        }
        localObject = paramqms.g;
        label139:
        localObject = localqze.h((String)localObject);
        if (paramqms == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paramqms = Long.valueOf(paramqms.f);; paramqms = null)
    {
      noo.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((qze)localObject).e(paramqms.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      qol.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      qol.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label247:
      paramqms = null;
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
    qmg localqmg = (qmg)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372601: 
    case 2131376548: 
      c((qms)localqmg);
      return;
    }
    b((qms)localqmg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qst
 * JD-Core Version:    0.7.0.1
 */