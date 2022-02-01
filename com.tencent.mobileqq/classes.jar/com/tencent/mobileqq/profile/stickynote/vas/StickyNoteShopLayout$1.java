package com.tencent.mobileqq.profile.stickynote.vas;

import QC.CommonRsp;
import QC.GetSuixintieSigFontRsp;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class StickyNoteShopLayout$1
  implements BusinessObserver
{
  StickyNoteShopLayout$1(StickyNoteShopLayout paramStickyNoteShopLayout, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof GetSuixintieSigFontRsp))
    {
      paramObject = (GetSuixintieSigFontRsp)paramObject;
      if ((paramObject.isEnd == 1) && (paramObject.vItems.size() == 1)) {
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = paramObject.toByteArray();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(StickyNoteShopLayout.a);
        localStringBuilder.append('_');
        localStringBuilder.append(StickyNoteShopLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout));
        FileUtils.writeFile((byte[])localObject, localStringBuilder.toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" isLoadMore:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" size:");
      ((StringBuilder)localObject).append(paramObject.stRet.ret);
      QLog.d("StickyNoteShopLayout", 2, ((StringBuilder)localObject).toString());
      StickyNoteShopLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout, paramObject.strAttachInfo);
      if ((paramObject.stRet.ret == 0) && (paramObject.vItems != null) && (paramObject.vItems.size() > 0))
      {
        ThreadManagerV2.getUIHandlerV2().post(new StickyNoteShopLayout.1.1(this, paramObject));
        return;
      }
      StickyNoteShopLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout, true);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (StickyNoteShopLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout).getItemCount() == 0)) {
      ThreadManagerV2.getUIHandlerV2().post(new StickyNoteShopLayout.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.1
 * JD-Core Version:    0.7.0.1
 */