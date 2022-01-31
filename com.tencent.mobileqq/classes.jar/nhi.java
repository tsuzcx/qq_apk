import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class nhi
{
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean b;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private nhn jdField_a_of_type_Nhn;
  private nia jdField_a_of_type_Nia;
  
  public nhi(nia paramnia, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Nia = paramnia;
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131301675));
    this.jdField_a_of_type_Nhn = new nhn(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Nhn);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Nhn);
    if ((odi.a()) && (jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramView.getContext().getResources().getDimensionPixelOffset(2131167493);
      return;
      jdField_a_of_type_Boolean = false;
      paramnia = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramnia.height = 0;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramnia);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, View paramView)
  {
    if (!jdField_a_of_type_Boolean) {}
    while ((paramTabChannelCoverInfo.redPoint == null) || (!paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    if ((paramTabChannelCoverInfo.redPoint.c != 0L) && ((float)(l - paramTabChannelCoverInfo.redPoint.c) > 2.5F) && ((float)(l / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) < 1.0F)) {}
    for (int i = 1; (i == 0) && (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long <= l) && ((paramTabChannelCoverInfo.redPoint.b == 0L) || (paramTabChannelCoverInfo.redPoint.b >= l)); i = 0)
    {
      Object localObject = this.jdField_a_of_type_Nia;
      if (nia.b)
      {
        QLog.d("IconTabController", 1, "showTextAnimation : " + paramTabChannelCoverInfo);
        paramView.setVisibility(0);
        localObject = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
        ((TranslateAnimation)localObject).setDuration(3000L);
        ((TranslateAnimation)localObject).setRepeatCount(1);
        ((TranslateAnimation)localObject).setStartOffset(1000L);
        ((TranslateAnimation)localObject).setFillAfter(true);
        ((TranslateAnimation)localObject).setAnimationListener(new nhm(this));
        paramView.startAnimation((Animation)localObject);
      }
      paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
      this.jdField_a_of_type_Nia.a(paramTabChannelCoverInfo);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (a()) {
      return;
    }
    QLog.d("IconTabController", 1, "showWithAnimation");
    jdField_a_of_type_Boolean = true;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.jdField_a_of_type_Int });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new nhj(this));
    localValueAnimator.start();
  }
  
  public void a(List<TabChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = paramList;
    if (paramList.size() > 11) {
      localObject = paramList.subList(0, 11);
    }
    ((List)localObject).add(new nhp(null));
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    this.jdField_a_of_type_Nhn.notifyDataSetChanged();
  }
  
  public void b()
  {
    odi.a(false);
    if ((this.jdField_a_of_type_AndroidViewView.getAlpha() <= 0.01D) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8)) {}
    while (b) {
      return;
    }
    QLog.d("IconTabController", 1, "hideWithAnimation");
    jdField_a_of_type_Boolean = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.jdField_a_of_type_Int });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new nhk(this));
    localValueAnimator.addListener(new nhl(this));
    localValueAnimator.start();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Nhn.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (odi.a())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (a()) {
        a();
      }
      return;
    }
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhi
 * JD-Core Version:    0.7.0.1
 */