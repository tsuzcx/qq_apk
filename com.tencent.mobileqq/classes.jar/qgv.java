import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class qgv
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qgv.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pzs jdField_a_of_type_Pzs;
  private qgu jdField_a_of_type_Qgu;
  private boolean jdField_a_of_type_Boolean;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public qgv(QQAppInterface paramQQAppInterface, Activity paramActivity, pzs parampzs, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qgu = new qgu(paramQQAppInterface);
    this.jdField_a_of_type_Int = azvv.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Pzs = parampzs;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, qaq paramqaq, VideoInfo paramVideoInfo)
  {
    this.c = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramqaq.r == null) && ((paramqaq instanceof qap)))
      {
        paramqaq.r = ((ViewGroup)((ViewStub)paramqaq.q.findViewById(2131313155)).inflate());
        paramqaq.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramqaq.r.findViewById(2131310331));
        paramqaq.A = ((TextView)paramqaq.r.findViewById(2131310332));
      }
      if (paramqaq.r != null)
      {
        paramqaq.r.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    while (paramECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bajq.a(32.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bajq.a(32.0F);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(azue.j);
        paramqaq.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        paramqaq.A.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        qcn.a(paramqaq.r, 200);
        paramqaq.r.setTag(paramqaq);
        paramqaq.r.setOnClickListener(this);
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        ndn.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new qmv(null, null, null, paramVideoInfo.g).Q(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).h(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString);
          }
        }
      }
    }
    if ((paramqaq.jdField_t_of_type_AndroidViewViewGroup == null) && (paramqaq.jdField_a_of_type_AndroidViewViewStub != null))
    {
      paramqaq.jdField_a_of_type_AndroidViewViewStub.inflate();
      paramqaq.jdField_t_of_type_AndroidViewViewGroup = ((ViewGroup)paramqaq.jdField_t_of_type_AndroidViewView.findViewById(2131306890));
      paramqaq.f = ((URLImageView)paramqaq.jdField_t_of_type_AndroidViewView.findViewById(2131310753));
      paramqaq.F = ((TextView)paramqaq.jdField_t_of_type_AndroidViewView.findViewById(2131310752));
      paramqaq.u = paramqaq.jdField_t_of_type_AndroidViewView.findViewById(2131310750);
      paramqaq.G = ((TextView)paramqaq.jdField_t_of_type_AndroidViewView.findViewById(2131310754));
      paramqaq.H = ((TextView)paramqaq.jdField_t_of_type_AndroidViewView.findViewById(2131310751));
      paramqaq.u.setTag(paramqaq);
      paramqaq.u.setOnClickListener(this);
      paramqaq.F.setTag(paramqaq);
      paramqaq.F.setOnClickListener(this);
    }
    qcn.a(paramqaq.jdField_t_of_type_AndroidViewViewGroup, 0);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
    localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
    paramqaq.f.setImageDrawable((Drawable)localObject2);
    int i;
    if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (bady.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
    {
      i = 1;
      label598:
      if (i == 0) {
        break label673;
      }
      paramqaq.F.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
    }
    for (;;)
    {
      paramqaq.G.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
      paramqaq.H.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
      paramqaq.jdField_a_of_type_Pxs.a(false);
      paramqaq.jdField_a_of_type_Pxs.b(false);
      this.jdField_a_of_type_Pzs.f(false);
      break;
      i = 0;
      break label598;
      label673:
      paramqaq.F.setText(paramECommerceEntranceInfo.g);
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    return (this.jdField_a_of_type_Qgu.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString)));
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, int paramInt1, int paramInt2)
  {
    if ((paramECommerceEntranceInfo.jdField_b_of_type_Int >= 0) && (paramInt1 >= paramECommerceEntranceInfo.jdField_b_of_type_Int)) {}
    while ((paramECommerceEntranceInfo.jdField_c_of_type_Int >= 0) && (paramInt1 / paramInt2 * 100.0F >= paramECommerceEntranceInfo.jdField_c_of_type_Int)) {
      return true;
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qgu.a();
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
  
  public void a(VideoInfo paramVideoInfo, qaq paramqaq, int paramInt1, int paramInt2)
  {
    if (paramqaq.jdField_a_of_type_Int != 2) {}
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
              } while (paramqaq.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0);
              if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
                break;
              }
            } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_b_of_type_Boolean) || (this.c) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
            a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramqaq, paramVideoInfo);
            this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
          return;
          if ((paramVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
          i = paramqaq.jdField_c_of_type_Int;
          if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) && (paramVideoInfo.c))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i + 1, true);
            return;
          }
        } while ((!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) || (this.jdField_b_of_type_Boolean) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.c) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramqaq, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramqaq.r == null) || (paramqaq.r.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramqaq.r.setVisibility(8);
  }
  
  public void a(qaq paramqaq)
  {
    this.c = false;
    this.jdField_b_of_type_Boolean = false;
    b(paramqaq);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(qaq paramqaq)
  {
    if ((paramqaq == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramqaq.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramqaq.r == null);
      paramqaq.r.setVisibility(8);
      return;
    } while (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1);
    if (paramqaq.jdField_t_of_type_AndroidViewViewGroup != null) {
      paramqaq.jdField_t_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    paramqaq.jdField_a_of_type_Pxs.a(true);
    paramqaq.jdField_a_of_type_Pxs.b(true);
    this.jdField_a_of_type_Pzs.f(true);
  }
  
  public void c(qaq paramqaq)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      this.c = false;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
        break label226;
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e)) {
        break;
      }
      obz.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
      b(paramqaq);
    } while (this.jdField_a_of_type_Boolean);
    label86:
    Object localObject;
    if ((paramqaq != null) && (paramqaq.jdField_a_of_type_Qeq != null))
    {
      paramqaq = paramqaq.jdField_a_of_type_Qeq.a;
      if (paramqaq == null) {
        break label259;
      }
      localObject = paramqaq.g;
      label95:
      qmv localqmv = new qmv(null, null, null, (String)localObject).Q(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
      if (paramqaq == null) {
        break label264;
      }
      localObject = paramqaq.g;
      label146:
      localObject = localqmv.h((String)localObject);
      if (paramqaq == null) {
        break label269;
      }
    }
    label259:
    label264:
    label269:
    for (paramqaq = Long.valueOf(paramqaq.f);; paramqaq = null)
    {
      ndn.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((qmv)localObject).e(paramqaq.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      qcn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      label226:
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      qcn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      paramqaq = null;
      break label86;
      localObject = null;
      break label95;
      localObject = null;
      break label146;
    }
  }
  
  public void onClick(View paramView)
  {
    qae localqae = (qae)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131306889: 
    case 2131310752: 
      c((qaq)localqae);
      return;
    }
    b((qaq)localqae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgv
 * JD-Core Version:    0.7.0.1
 */