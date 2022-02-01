package me.ele.uetool.dialog;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.BriefDescItem;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;

public class AttrsDialog$Adapter$BriefDescViewHolder
  extends AttrsDialog.Adapter.BaseViewHolder<BriefDescItem>
{
  private TextView vDesc;
  
  public AttrsDialog$Adapter$BriefDescViewHolder(View paramView, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
  {
    super(paramView);
    this.vDesc = ((TextView)paramView);
    this.vDesc.setOnClickListener(new AttrsDialog.Adapter.BriefDescViewHolder.1(this, paramAttrDialogCallback));
  }
  
  public static BriefDescViewHolder newInstance(ViewGroup paramViewGroup, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
  {
    return new BriefDescViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_brief_view_desc"), paramViewGroup, false), paramAttrDialogCallback);
  }
  
  public void bindView(BriefDescItem paramBriefDescItem)
  {
    super.bindView(paramBriefDescItem);
    Object localObject = paramBriefDescItem.getElement().getView();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject.getClass().getName());
    localObject = Util.getResourceName(((View)localObject).getId());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStringBuilder.append("@").append((String)localObject);
    }
    this.vDesc.setText(localStringBuilder.toString());
    this.vDesc.setSelected(paramBriefDescItem.isSelected());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.BriefDescViewHolder
 * JD-Core Version:    0.7.0.1
 */