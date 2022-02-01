package com.tencent.mobileqq.emoticonview.relateemo;

import com.tencent.mobileqq.app.RelatedEmoSearchObserver;

class RelatedEmoticonManager$1
  extends RelatedEmoSearchObserver
{
  RelatedEmoticonManager$1(RelatedEmoticonManager paramRelatedEmoticonManager) {}
  
  protected void onSearchRelatedEmoError(int paramInt)
  {
    if (RelatedEmoticonManager.access$000(this.this$0) != null) {
      RelatedEmoticonManager.access$000(this.this$0).onError(paramInt);
    }
  }
  
  protected void onSearchRelatedEmoResponse(RelatedEmoticonManager.RelatedEmotionSearchResult paramRelatedEmotionSearchResult)
  {
    if (RelatedEmoticonManager.access$000(this.this$0) != null) {
      RelatedEmoticonManager.access$000(this.this$0).onResult(paramRelatedEmotionSearchResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.1
 * JD-Core Version:    0.7.0.1
 */