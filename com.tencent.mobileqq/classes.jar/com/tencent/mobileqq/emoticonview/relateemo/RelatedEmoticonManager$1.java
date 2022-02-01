package com.tencent.mobileqq.emoticonview.relateemo;

import anab;

class RelatedEmoticonManager$1
  extends anab
{
  RelatedEmoticonManager$1(RelatedEmoticonManager paramRelatedEmoticonManager) {}
  
  public void onSearchRelatedEmoError(int paramInt)
  {
    if (RelatedEmoticonManager.access$000(this.this$0) != null) {
      RelatedEmoticonManager.access$000(this.this$0).onError(paramInt);
    }
  }
  
  public void onSearchRelatedEmoResponse(RelatedEmoticonManager.RelatedEmotionSearchResult paramRelatedEmotionSearchResult)
  {
    if (RelatedEmoticonManager.access$000(this.this$0) != null) {
      RelatedEmoticonManager.access$000(this.this$0).onResult(paramRelatedEmotionSearchResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.1
 * JD-Core Version:    0.7.0.1
 */