package me.ele.uetool.view;

import android.app.Activity;
import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Builder;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight.Shape;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.guide.model.HighlightOptions.Builder;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.UETCore;
import me.ele.uetool.base.Element;
import me.ele.uetool.dialog.AttrsDialog;
import me.ele.uetool.dialog.AttrsDialog.AttrDialogCallback;
import me.ele.uetool.util.JarResource;

class EditAttrLayout$4
  implements AttrsDialog.AttrDialogCallback
{
  EditAttrLayout$4(EditAttrLayout paramEditAttrLayout) {}
  
  public void enableMove()
  {
    EditAttrLayout.access$202(this.this$0, new EditAttrLayout.MoveMode(this.this$0));
    this.this$0.dismissAttrsDialog();
  }
  
  public void selectMultipleView()
  {
    EditAttrLayout.access$600(this.this$0).dismiss();
    EditAttrLayout.access$202(this.this$0, new EditAttrLayout.MultipleChosenMode(this.this$0));
    Object localObject = new HighlightOptions.Builder().setOnHighlightDrewListener(new EditAttrLayout.4.1(this)).build();
    localObject = GuidePage.newInstance().setEverywhereCancelable(true).addHighLightWithOptions(EditAttrLayout.access$300(this.this$0).getView(), HighLight.Shape.RECTANGLE, (HighlightOptions)localObject).setLayoutRes(JarResource.getIdByName("layout", "qb_uet_view_guide_anchor"), new int[0]);
    if (EditAttrLayout.access$700(this.this$0) != null)
    {
      Iterator localIterator = EditAttrLayout.access$700(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((GuidePage)localObject).addHighLight(((Element)localIterator.next()).getView());
      }
    }
    NewbieGuide.with((Activity)EditAttrLayout.access$800(this.this$0)).setLabel("guide").setShowCounts(1).addGuidePage((GuidePage)localObject).show();
  }
  
  public void selectView(Element paramElement)
  {
    EditAttrLayout.access$302(this.this$0, paramElement);
    this.this$0.dismissAttrsDialog();
    EditAttrLayout.access$600(this.this$0).show(EditAttrLayout.access$300(this.this$0));
  }
  
  public void showReason(int paramInt, boolean paramBoolean)
  {
    paramInt += 1;
    if (paramBoolean)
    {
      EditAttrLayout.access$600(this.this$0).notifyReasonItemInserted(paramInt, UETCore.reason);
      return;
    }
    EditAttrLayout.access$600(this.this$0).notifyItemRangeRemoved(paramInt);
  }
  
  public void showValidViews(int paramInt, boolean paramBoolean)
  {
    paramInt += 1;
    if (paramBoolean)
    {
      EditAttrLayout.access$600(this.this$0).notifyValidViewItemInserted(paramInt, this.this$0.getTargetElements(EditAttrLayout.access$000(this.this$0), EditAttrLayout.access$100(this.this$0)), EditAttrLayout.access$300(this.this$0));
      return;
    }
    EditAttrLayout.access$600(this.this$0).notifyItemRangeRemoved(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.4
 * JD-Core Version:    0.7.0.1
 */