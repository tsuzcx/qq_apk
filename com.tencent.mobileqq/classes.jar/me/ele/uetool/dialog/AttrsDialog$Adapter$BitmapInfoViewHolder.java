package me.ele.uetool.dialog;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.util.JarResource;

public class AttrsDialog$Adapter$BitmapInfoViewHolder
  extends AttrsDialog.Adapter.BaseViewHolder<BitmapItem>
{
  private final int imageHeight = DimenUtil.dip2px(58.0F);
  private ImageView vImage;
  private TextView vInfo;
  private TextView vName;
  
  public AttrsDialog$Adapter$BitmapInfoViewHolder(View paramView)
  {
    super(paramView);
    this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
    this.vImage = ((ImageView)paramView.findViewById(JarResource.getIdByName("id", "image")));
    this.vInfo = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "info")));
  }
  
  public static BitmapInfoViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new BitmapInfoViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_bitmap_info"), paramViewGroup, false));
  }
  
  public void bindView(BitmapItem paramBitmapItem)
  {
    super.bindView(paramBitmapItem);
    this.vName.setText(paramBitmapItem.getName());
    paramBitmapItem = paramBitmapItem.getBitmap();
    int i = Math.min(paramBitmapItem.getHeight(), this.imageHeight);
    int j = (int)(i / paramBitmapItem.getHeight() * paramBitmapItem.getWidth());
    ViewGroup.LayoutParams localLayoutParams = this.vImage.getLayoutParams();
    localLayoutParams.width = j;
    localLayoutParams.height = i;
    this.vImage.setImageBitmap(paramBitmapItem);
    this.vInfo.setText(paramBitmapItem.getWidth() + "px*" + paramBitmapItem.getHeight() + "px");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.BitmapInfoViewHolder
 * JD-Core Version:    0.7.0.1
 */