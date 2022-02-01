package cooperation.vip.ad;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class TianshuBigInsertPage
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private TianShuAccess.AdItem jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
  private View b;
  
  public TianshuBigInsertPage(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().findViewById(2131365172));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getLayoutInflater().inflate(2131558582, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131378674);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131378669).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getColor(2131165482));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378670));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new TianshuBigInsertPage.1(this));
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378671)).setOnClickListener(new TianshuBigInsertPage.2(this));
  }
  
  private void b()
  {
    ViewUtils.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  private static void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null)
    {
      QLog.e("TianshuBigInsertPage", 2, "showLayer with null ");
      return;
    }
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
    Object localObject = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    String str = null;
    paramAdItem = null;
    while (((Iterator)localObject).hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
      if (localMapEntry.key.get().equals("image")) {
        str = localMapEntry.value.get();
      } else if (localMapEntry.key.get().equals("url")) {
        paramAdItem = localMapEntry.value.get();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showHongbaoLayer | imgUrl is: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" actionUrl: ");
      ((StringBuilder)localObject).append(paramAdItem);
      QLog.d("TianshuBigInsertPage", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new TianshuBigInsertPage.3(this, paramAdItem));
    PreloadStaticApi.a().getResPath(str, new TianshuBigInsertPage.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage
 * JD-Core Version:    0.7.0.1
 */