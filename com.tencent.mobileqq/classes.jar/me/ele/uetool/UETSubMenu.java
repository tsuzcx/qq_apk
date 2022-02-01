package me.ele.uetool;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.util.JarResource;

public class UETSubMenu
  extends LinearLayout
{
  private UETSubMenu.ChangeStatus changeStatus = new UETSubMenu.ChangeStatus(this);
  private final int padding = DimenUtil.dip2px(5.0F);
  private UETSubMenu.SubMenu subMenu;
  private ImageView vImage;
  private TextView vTitle;
  
  public UETSubMenu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UETSubMenu(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UETSubMenu(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, JarResource.getIdByName("layout", "qb_uet_sub_menu_layout"), this);
    setGravity(17);
    setOrientation(1);
    setPadding(this.padding, 0, this.padding, 0);
    setTranslationY(DimenUtil.dip2px(2.0F));
    this.vImage = ((ImageView)findViewById(JarResource.getIdByName("id", "image")));
    this.vTitle = ((TextView)findViewById(JarResource.getIdByName("id", "title")));
  }
  
  public UETSubMenu.ChangeStatus getChangeStatus()
  {
    return this.changeStatus;
  }
  
  public void update(UETSubMenu.SubMenu paramSubMenu)
  {
    this.subMenu = paramSubMenu;
    this.vImage.setImageResource(paramSubMenu.getChosenImageRes());
    this.vTitle.setText(paramSubMenu.getTitle());
    setOnClickListener(paramSubMenu.getOnClickListener());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETSubMenu
 * JD-Core Version:    0.7.0.1
 */