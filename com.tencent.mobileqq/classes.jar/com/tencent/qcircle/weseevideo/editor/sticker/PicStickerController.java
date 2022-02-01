package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsPicStickerContentView;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tavsticker.core.TAVStickerContext;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class PicStickerController
  extends StickerController
{
  private int containerHeight = -1;
  private int containerWidth = -1;
  
  public PicStickerController(Context paramContext, @Nullable StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    super(paramContext, paramStickerEditViewIconConfig);
  }
  
  public void checkContainerSize(ViewGroup paramViewGroup)
  {
    super.checkContainerSize(paramViewGroup);
    paramViewGroup = paramViewGroup.getLayoutParams();
    if ((paramViewGroup.width != this.containerWidth) || (paramViewGroup.height != this.containerHeight))
    {
      this.containerWidth = paramViewGroup.width;
      this.containerHeight = paramViewGroup.height;
      if ((this.stickerContentView instanceof WsPicStickerContentView))
      {
        Iterator localIterator = ((WsPicStickerContentView)this.stickerContentView).getStickerEditViews().iterator();
        while (localIterator.hasNext()) {
          ((WsStickerEditView)localIterator.next()).initLocation(paramViewGroup.width, paramViewGroup.height);
        }
      }
    }
  }
  
  protected TAVStickerContext createStickerContextInner(Context paramContext)
  {
    return new WsPicStickerContext(paramContext);
  }
  
  protected void initContentView(Context paramContext)
  {
    this.stickerContentView = new WsPicStickerContentView(paramContext);
  }
  
  public void setAddingMultiSticker(boolean paramBoolean)
  {
    if ((this.stickerContext instanceof WsPicStickerContext)) {
      ((WsPicStickerContext)this.stickerContext).setAddingTemplate(paramBoolean);
    }
  }
  
  public void setStickersVisible() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.PicStickerController
 * JD-Core Version:    0.7.0.1
 */