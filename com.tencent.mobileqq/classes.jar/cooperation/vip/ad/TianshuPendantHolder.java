package cooperation.vip.ad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.onPendentClickListener;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class TianshuPendantHolder
  extends ConversationActivePendantHolderBase
  implements ARMapHongBaoListView.onPendentClickListener
{
  public static float c = 112.0F;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TianshuPendantHolder.AnimationDrawableProxyView jdField_a_of_type_CooperationVipAdTianshuPendantHolder$AnimationDrawableProxyView;
  private TianShuAccess.AdItem jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem;
  private String jdField_a_of_type_JavaLangString;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public TianshuPendantHolder(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838451);
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ARMapHongBaoListView))) {
      ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).setPendantHolder(null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem != null)) {
      TianshuAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 122, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
    }
  }
  
  private void h()
  {
    TianshuAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 4004);
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ARMapHongBaoListView)))
    {
      ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).setPendantHolder(null);
      ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewView).setOnPendentClickListener(null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem != null)) {
      TianshuAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 102, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
    }
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_b_of_type_AndroidGraphicsRect != null) && (this.jdField_b_of_type_AndroidGraphicsRect.contains((int)paramFloat1, (int)paramFloat2)))
    {
      a();
      return;
    }
    h();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      QLog.e("TianshuPendantHolder", 2, "showLayer with null ");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
        this.jdField_a_of_type_JavaLangString = null;
        Object localObject = paramAdItem.argList.get().iterator();
        paramAdItem = null;
        if (((Iterator)localObject).hasNext())
        {
          TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
          if (localMapEntry.key.get().equals("image")) {
            paramAdItem = localMapEntry.value.get();
          }
          for (;;)
          {
            break;
            if (localMapEntry.key.get().equals("url")) {
              this.jdField_a_of_type_JavaLangString = localMapEntry.value.get();
            }
          }
        }
        if ((TextUtils.isEmpty(paramAdItem)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          break;
        }
        localObject = URLDrawableHelper.TRANSPARENT;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngURLDrawable(paramAdItem, new int[] { 2 }, (Drawable)localObject, null, null);
      } while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null);
      this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder$AnimationDrawableProxyView = new TianshuPendantHolder.AnimationDrawableProxyView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null));
    TianshuAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, String.valueOf(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get()), this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get());
    return;
    QLog.e("TianshuPendantHolder", 1, "setpendantres error with image url " + paramAdItem + " jumpUrl " + this.jdField_a_of_type_JavaLangString);
  }
  
  public RectF b(int paramInt)
  {
    float f = -AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.j - f, this.k - f - paramInt, this.j + this.l + f, f + (this.k + this.m) - paramInt);
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  public void b()
  {
    try
    {
      i();
      if (QLog.isColorLevel()) {
        QLog.i("TianshuPendantHolder", 2, "stopAnimation...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void b(float paramFloat1, float paramFloat2) {}
  
  public void b(Canvas paramCanvas)
  {
    super.b(paramCanvas);
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramCanvas.save();
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
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
      j = AIOUtils.a(160.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(i - j - 0, 0, j, AIOUtils.a(c, this.jdField_a_of_type_AndroidViewView.getResources()), this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.j + j - AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.k + AIOUtils.a(22.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.j + j - AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.k + AIOUtils.a(37.0F, this.jdField_a_of_type_AndroidViewView.getResources()));
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(this.j + j - AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.k, j + this.j, this.k + AIOUtils.a(37.0F, this.jdField_a_of_type_AndroidViewView.getResources()));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuPendantHolder
 * JD-Core Version:    0.7.0.1
 */