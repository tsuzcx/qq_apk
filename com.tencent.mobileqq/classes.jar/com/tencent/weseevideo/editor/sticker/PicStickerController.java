package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.weseevideo.editor.sticker.view.WsPicStickerContentView;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class PicStickerController
  extends StickerController
{
  private int a = -1;
  private int b = -1;
  
  public PicStickerController(Context paramContext, @Nullable StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    super(paramContext, paramStickerEditViewIconConfig);
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if ((this.stickerContext instanceof WsPicStickerContext)) {
      ((WsPicStickerContext)this.stickerContext).a(paramBoolean);
    }
  }
  
  public void checkContainerSize(ViewGroup paramViewGroup)
  {
    super.checkContainerSize(paramViewGroup);
    paramViewGroup = paramViewGroup.getLayoutParams();
    if ((paramViewGroup.width != this.b) || (paramViewGroup.height != this.a))
    {
      this.b = paramViewGroup.width;
      this.a = paramViewGroup.height;
      if ((this.stickerContentView instanceof WsPicStickerContentView))
      {
        Iterator localIterator = ((WsPicStickerContentView)this.stickerContentView).a().iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.PicStickerController
 * JD-Core Version:    0.7.0.1
 */