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
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().findViewById(2131365297));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getLayoutInflater().inflate(2131558684, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131379322);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131379317).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getColor(2131165506));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379318));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new TianshuBigInsertPage.1(this));
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379319)).setOnClickListener(new TianshuBigInsertPage.2(this));
  }
  
  private void b()
  {
    QwUtils.a(this.jdField_a_of_type_AndroidViewView);
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
    Object localObject1 = null;
    if (paramAdItem == null)
    {
      QLog.e("TianshuBigInsertPage", 2, "showLayer with null ");
      return;
    }
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
    Iterator localIterator = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    paramAdItem = null;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)localIterator.next();
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("image"))
      {
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        paramAdItem = (TianShuAccess.AdItem)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramAdItem;
      paramAdItem = (TianShuAccess.AdItem)localObject2;
      break;
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("url"))
      {
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        localObject1 = paramAdItem;
        paramAdItem = (TianShuAccess.AdItem)localObject2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TianshuBigInsertPage", 2, "showHongbaoLayer | imgUrl is: " + paramAdItem + " actionUrl: " + (String)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new TianshuBigInsertPage.3(this, (String)localObject1));
        PreloadStaticApi.a().getResPath(paramAdItem, new TianshuBigInsertPage.4(this));
      }
      else
      {
        localObject2 = paramAdItem;
        paramAdItem = (TianShuAccess.AdItem)localObject1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage
 * JD-Core Version:    0.7.0.1
 */