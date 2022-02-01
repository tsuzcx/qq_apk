package com.tencent.ttpic.openapi.cache;

import com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent;
import com.tencent.ttpic.openapi.extrastickerutil.IExtraStickerParser;
import com.tencent.ttpic.openapi.model.StickerItem;

public class LoadPagItemManager
  extends LoadExtraStickerParserManager
{
  private final String PAG_SUFFIX = ".pag";
  private final String TAG = "LoadPagItemManager";
  private String mPagName;
  
  public LoadPagItemManager(String paramString, StickerItem paramStickerItem)
  {
    super(paramString, paramStickerItem);
    if (paramStickerItem == null) {
      return;
    }
    this.mStickerParser = ExtraStickerParserAgent.getInstance().creatPagParser();
    if (this.mStickerParser != null)
    {
      if ((paramStickerItem.extarTypeHeight > 0) && (paramStickerItem.extraTypeWidth > 0))
      {
        this.mWidth = paramStickerItem.extraTypeWidth;
        this.mHeight = paramStickerItem.extarTypeHeight;
      }
      else
      {
        this.mWidth = paramStickerItem.width;
        this.mHeight = paramStickerItem.height;
      }
      this.mStickerParser.setSize(this.mWidth, this.mHeight);
    }
    paramString = new StringBuilder();
    paramString.append(paramStickerItem.id);
    paramString.append(".pag");
    this.mPagName = paramString.toString();
  }
  
  public void prepareImages()
  {
    if (!this.mIsPrepared) {
      return;
    }
    if (this.mStickerParser == null) {
      this.mStickerParser = ExtraStickerParserAgent.getInstance().creatPagParser();
    }
    if (this.mStickerParser == null) {
      return;
    }
    this.mIsPrepared = this.mStickerParser.prepare(this.mDataPath, this.mPagName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.LoadPagItemManager
 * JD-Core Version:    0.7.0.1
 */