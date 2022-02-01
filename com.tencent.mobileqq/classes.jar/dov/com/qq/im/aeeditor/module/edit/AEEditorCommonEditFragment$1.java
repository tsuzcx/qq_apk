package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.app.HardCodeUtil;
import dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView.OnCheckedChangeListener;
import dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar.ImageToolBarListener;
import dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar.VideoToolBarListener;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import org.jetbrains.annotations.NotNull;

class AEEditorCommonEditFragment$1
  implements AEEditorCheckGroupView.OnCheckedChangeListener
{
  AEEditorCommonEditFragment$1(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public boolean a(@NotNull AEEditorCheckGroupView paramAEEditorCheckGroupView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a(paramInt);
      return true;
      if ((this.a instanceof AEEditorImageEditFragment))
      {
        this.a.a.setTitle(HardCodeUtil.a(2131689734));
      }
      else
      {
        this.a.a.setTitle(HardCodeUtil.a(2131689735));
        continue;
        if ((this.a instanceof ImageEditToolBar.ImageToolBarListener)) {
          ((ImageEditToolBar.ImageToolBarListener)this.a).A();
        }
        if ((this.a instanceof VideoEditToolBar.VideoToolBarListener))
        {
          ((VideoEditToolBar.VideoToolBarListener)this.a).B();
          continue;
          if ((this.a instanceof VideoEditToolBar.VideoToolBarListener))
          {
            ((VideoEditToolBar.VideoToolBarListener)this.a).D();
            continue;
            this.a.a.setTitle(HardCodeUtil.a(2131689735));
            if ((this.a instanceof VideoEditToolBar.VideoToolBarListener)) {
              ((VideoEditToolBar.VideoToolBarListener)this.a).C();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.1
 * JD-Core Version:    0.7.0.1
 */