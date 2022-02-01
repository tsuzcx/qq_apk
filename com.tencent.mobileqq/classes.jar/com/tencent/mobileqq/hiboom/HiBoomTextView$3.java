package com.tencent.mobileqq.hiboom;

import com.etrump.mixlayout.EMEmoticon;
import com.tencent.commonsdk.cache.QQLruCache;

final class HiBoomTextView$3
  extends QQLruCache<String, EMEmoticon>
{
  HiBoomTextView$3(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected void a(boolean paramBoolean, String paramString, EMEmoticon paramEMEmoticon1, EMEmoticon paramEMEmoticon2)
  {
    super.entryRemoved(paramBoolean, paramString, paramEMEmoticon1, paramEMEmoticon2);
    if (paramEMEmoticon1 != null) {
      paramEMEmoticon1.deleteDescriptor();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.3
 * JD-Core Version:    0.7.0.1
 */