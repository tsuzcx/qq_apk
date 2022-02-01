package cooperation.vip.ad;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class TianshuBreathLight
  extends ConversationActivePendantHolderBase
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AnimationDrawableProxyView jdField_a_of_type_CooperationVipAdAnimationDrawableProxyView;
  private TianShuAccess.AdItem jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
  
  public TianshuBreathLight(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null)
    {
      QLog.e("ConvActivePendantHolderBase", 2, "showLayer with null ");
      return;
    }
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
    Object localObject1 = paramAdItem.argList.get().iterator();
    paramAdItem = null;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
      if (((TianShuAccess.MapEntry)localObject2).key.get().equals("image")) {
        paramAdItem = ((TianShuAccess.MapEntry)localObject2).value.get();
      }
    }
    if (!TextUtils.isEmpty(paramAdItem))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_loop", 1);
      localObject2 = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngURLDrawable(paramAdItem, new int[] { 2 }, (Drawable)localObject2, (Bundle)localObject1, null);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_CooperationVipAdAnimationDrawableProxyView = new AnimationDrawableProxyView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        c();
        paramAdItem = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramAdItem != null)
        {
          localObject1 = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
          if (localObject1 != null) {
            TianshuAdUtils.a(paramAdItem, 101, String.valueOf(((TianShuAccess.AdItem)localObject1).iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
          }
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      int j = this.jdField_a_of_type_AndroidViewView.getWidth();
      int i = j;
      if (j == 0) {
        i = ScreenUtil.SCREEN_WIDTH;
      }
      j = AIOUtils.b(375.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(i - j + 0, 0, j, AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ConvActivePendantHolderBase", 1, localThrowable, new Object[0]);
    }
  }
  
  public void g()
  {
    super.g();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      TianShuAccess.AdItem localAdItem = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
      if (localAdItem != null)
      {
        TianshuAdUtils.a(localQQAppInterface, 102, String.valueOf(localAdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
        if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ARMapHongBaoListView))) {
          ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).h();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBreathLight
 * JD-Core Version:    0.7.0.1
 */