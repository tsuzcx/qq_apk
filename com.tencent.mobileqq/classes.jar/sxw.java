import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.EmptyStackException;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class sxw
  implements Runnable
{
  sxw(sxv paramsxv, oidb_0x791.RedDotInfo paramRedDotInfo, TroopRedTouchManager paramTroopRedTouchManager) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$RedDotInfo;
    int i;
    int j;
    if ((Leba.a(this.jdField_a_of_type_Sxv.a) != null) && (Leba.c(this.jdField_a_of_type_Sxv.a) != null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("XingquBuluo", 4, "updateXingquBuluoRedFlag");
      }
      Leba.a(this.jdField_a_of_type_Sxv.a).setVisibility(8);
      Leba.a(this.jdField_a_of_type_Sxv.a).setImageDrawable(null);
      boolean bool = SharedPreUtils.k(this.jdField_a_of_type_Sxv.a.a(), this.jdField_a_of_type_Sxv.a.a.getCurrentAccountUin());
      if ((localObject1 == null) || (!((oidb_0x791.RedDotInfo)localObject1).uint32_number.has()) || (((oidb_0x791.RedDotInfo)localObject1).uint32_number.get() <= 0) || (!bool)) {
        break label256;
      }
      i = ((oidb_0x791.RedDotInfo)localObject1).uint32_number.get();
      j = 3;
    }
    for (;;)
    {
      CustomWidgetUtil.a(Leba.c(this.jdField_a_of_type_Sxv.a), j, i, 0);
      CustomWidgetUtil.a(this.jdField_a_of_type_Sxv.a.a(), Leba.c(this.jdField_a_of_type_Sxv.a), j);
      this.jdField_a_of_type_Sxv.a.a(1);
      if ((AppSetting.b) && (localObject1 != null))
      {
        if ((j == 3) && (i > 0)) {
          Leba.b(this.jdField_a_of_type_Sxv.a).setContentDescription("兴趣部落 " + i + "条更新");
        }
      }
      else
      {
        return;
        label256:
        oidb_0x791.RedDotInfo localRedDotInfo = this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.a(1);
        if (localRedDotInfo != null)
        {
          if ((localRedDotInfo.uint64_cmd_uin.has()) && (localRedDotInfo.uint64_cmd_uin.get() > 0L)) {}
          try
          {
            localDrawable = this.jdField_a_of_type_Sxv.a.a().getDrawable(2130839132);
            localObject1 = localObject3;
            if (localRedDotInfo.str_face_url.has())
            {
              localObject1 = localObject3;
              if (localRedDotInfo.str_face_url.get() != null)
              {
                str = localRedDotInfo.str_face_url.get().toStringUtf8();
                localObject1 = localObject3;
                if (!TextUtils.isEmpty(str))
                {
                  i = AIOUtils.a(31.0F, this.jdField_a_of_type_Sxv.a.a());
                  localObject1 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
                  ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
                }
              }
            }
          }
          catch (EmptyStackException localEmptyStackException)
          {
            try
            {
              String str;
              localObject1 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1);
              ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
              localObject3 = localObject1;
              if (localObject1 == null)
              {
                localObject3 = localObject1;
                if (localRedDotInfo.uint64_cmd_uin.has()) {
                  localObject3 = FaceDrawable.a(this.jdField_a_of_type_Sxv.a.a, String.valueOf(localRedDotInfo.uint64_cmd_uin.get()), (byte)3);
                }
              }
              if (localObject3 != null)
              {
                Leba.a(this.jdField_a_of_type_Sxv.a).setImageDrawable((Drawable)localObject3);
                Leba.a(this.jdField_a_of_type_Sxv.a).setVisibility(0);
                i = 0;
                j = 1;
                localObject1 = localRedDotInfo;
                continue;
                localEmptyStackException = localEmptyStackException;
                if (QLog.isColorLevel()) {
                  QLog.d("Leba", 2, "EmptyStackException");
                }
                localDrawable = null;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Drawable localDrawable;
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.lebatab.leba", 2, "updateXingquBuluoRedFlag, run exception:", localException);
                  localObject2 = localObject3;
                  continue;
                  Leba.a(this.jdField_a_of_type_Sxv.a).setImageDrawable(localDrawable);
                }
              }
            }
          }
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentBizTroopRedpointTroopRedTouchManager.a(6);
        if (localObject2 == null) {
          break label635;
        }
        j = 1;
        i = 0;
        continue;
      }
      Leba.b(this.jdField_a_of_type_Sxv.a).setContentDescription("兴趣部落 有更新");
      return;
      label635:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxw
 * JD-Core Version:    0.7.0.1
 */