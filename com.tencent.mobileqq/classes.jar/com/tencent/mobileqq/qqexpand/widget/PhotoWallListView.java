package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationExtendFriendPhotoWall;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationExtendFriendPhotoWall;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PhotoWallListView
  extends FrameLayout
  implements View.OnClickListener
{
  private QBaseActivity a;
  private Context b;
  private List<RoundCornerImageView> c = new ArrayList();
  private ArrayList<PhotoWallListView.PhotoPath> d;
  private long e = 0L;
  private long f = 3000L;
  
  public PhotoWallListView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    b();
  }
  
  public PhotoWallListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    b();
  }
  
  public PhotoWallListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    b();
  }
  
  private Drawable a(String paramString)
  {
    paramString = b(paramString);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = ((RoundCornerImageView)this.c.get(0)).getWidth();
    localURLDrawableOptions.mRequestHeight = ((RoundCornerImageView)this.c.get(0)).getHeight();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(this.a, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putStringArrayList("seqNum", PhotoWallListView.PhotoPath.a(this.d));
    localBundle.putBoolean("delete_ability", true);
    localBundle.putBoolean("SHOW_MENU", true);
    localBundle.putBoolean("is_show_action", false);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("from_extend_Friend_edit", true);
    localBundle.putBundle("bundle_data_extra", (Bundle)localObject);
    localObject = new int[2];
    ImageView localImageView = (ImageView)this.c.get(paramInt);
    localImageView.getLocationOnScreen((int[])localObject);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(localObject[0]));
    localArrayList.add(Integer.valueOf(localObject[1]));
    localArrayList.add(Integer.valueOf(localImageView.getWidth()));
    localArrayList.add(Integer.valueOf(localImageView.getHeight()));
    localBundle.putIntegerArrayList("mPreviewPhotoLocation", localArrayList);
    localIntent.putExtras(localBundle);
    this.a.startActivityForResult(localIntent, 5001);
  }
  
  private URL b(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https")))) {
        return new URL(paramString);
      }
      paramString = new File(paramString).toURL();
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      QLog.e("PhotoWallListView", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private void b()
  {
    RoundCornerImageView localRoundCornerImageView = new RoundCornerImageView(this.b);
    localRoundCornerImageView.setId(80400);
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRoundCornerImageView.setCorner(8, 8, 8, 8);
    localRoundCornerImageView.setImageDrawable(this.b.getResources().getDrawable(1912864770));
    this.c.add(localRoundCornerImageView);
    localRoundCornerImageView = new RoundCornerImageView(this.b);
    localRoundCornerImageView.setId(80401);
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRoundCornerImageView.setCorner(8, 8, 8, 8);
    this.c.add(localRoundCornerImageView);
    localRoundCornerImageView = new RoundCornerImageView(this.b);
    localRoundCornerImageView.setId(80402);
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRoundCornerImageView.setCorner(8, 8, 8, 8);
    this.c.add(localRoundCornerImageView);
    localRoundCornerImageView = new RoundCornerImageView(this.b);
    localRoundCornerImageView.setId(80403);
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRoundCornerImageView.setCorner(8, 8, 8, 8);
    this.c.add(localRoundCornerImageView);
    int i = 0;
    while (i < 4)
    {
      addView((View)this.c.get(i));
      ((RoundCornerImageView)this.c.get(i)).setOnClickListener(this);
      i += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if (c()) {
      return;
    }
    Intent localIntent = new Intent(this.a, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 54);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationExtendFriendPhotoWall.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationExtendFriendPhotoWall.a);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 4 - paramInt);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", false);
    localIntent.putExtra("peakconstant.request_code", 10020);
    this.a.startActivityForResult(localIntent, 10020);
  }
  
  private boolean c()
  {
    long l = System.currentTimeMillis();
    if (l - this.e >= this.f)
    {
      this.e = l;
      return false;
    }
    this.f = 1000L;
    return true;
  }
  
  public void a()
  {
    int i = 0;
    while (i < 4)
    {
      Drawable localDrawable;
      if ((i < this.d.size()) && (!TextUtils.isEmpty(((PhotoWallListView.PhotoPath)this.d.get(i)).a())))
      {
        localDrawable = a(((PhotoWallListView.PhotoPath)this.d.get(i)).a());
        ((RoundCornerImageView)this.c.get(i)).setImageDrawable(localDrawable);
        ((RoundCornerImageView)this.c.get(i)).setVisibility(0);
      }
      else if (i == this.d.size())
      {
        localDrawable = this.b.getResources().getDrawable(1912864770);
        ((RoundCornerImageView)this.c.get(i)).setImageDrawable(localDrawable);
        ((RoundCornerImageView)this.c.get(i)).setVisibility(0);
      }
      else
      {
        localDrawable = this.b.getResources().getDrawable(2131168376);
        ((RoundCornerImageView)this.c.get(i)).setImageDrawable(localDrawable);
        ((RoundCornerImageView)this.c.get(i)).setVisibility(4);
      }
      i += 1;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.d.clear();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i)))
        {
          PhotoWallListView.PhotoPath localPhotoPath = new PhotoWallListView.PhotoPath((String)paramArrayList.get(i), null);
          this.d.add(localPhotoPath);
        }
        if (this.d.size() == 4) {
          return;
        }
        i += 1;
      }
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i)))
        {
          PhotoWallListView.PhotoPath localPhotoPath = new PhotoWallListView.PhotoPath(null, (String)paramArrayList.get(i));
          this.d.add(localPhotoPath);
        }
        if (this.d.size() == 4) {
          return;
        }
        i += 1;
      }
    }
  }
  
  public void c(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        int j = 0;
        while (j < this.d.size()) {
          if ((!((String)paramArrayList.get(i)).equals(((PhotoWallListView.PhotoPath)this.d.get(j)).b)) && (!((String)paramArrayList.get(i)).equals(((PhotoWallListView.PhotoPath)this.d.get(j)).a))) {
            j += 1;
          } else {
            this.d.remove(j);
          }
        }
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < 4)
    {
      if (paramView.getId() == ((RoundCornerImageView)this.c.get(i)).getId()) {
        if (i < this.d.size())
        {
          a(i);
        }
        else if (i == this.d.size())
        {
          ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#add_photo_btn", true, -1L, -1L, null, true, true);
          b(i);
        }
      }
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = Math.abs(paramInt3 - paramInt1);
    paramInt1 = (int)this.b.getResources().getDimension(1912799232);
    paramInt4 = (int)this.b.getResources().getDimension(1912799234);
    int i = (paramInt2 - paramInt1 * 2 - paramInt4 * 3) / 4;
    paramInt3 = paramInt1 - i - paramInt4;
    paramInt2 = paramInt1 - paramInt4;
    paramInt1 = 0;
    while (paramInt1 < 4)
    {
      int j = i + paramInt4;
      paramInt3 += j;
      paramInt2 += j;
      ((RoundCornerImageView)this.c.get(paramInt1)).layout(paramInt3, 0, paramInt2, i);
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(paramInt1, (paramInt1 - (int)this.b.getResources().getDimension(1912799232) * 2 - (int)this.b.getResources().getDimension(1912799234) * 3) / 4);
  }
  
  public void setActivity(QBaseActivity paramQBaseActivity)
  {
    this.a = paramQBaseActivity;
  }
  
  public void setPhotoPathList(ArrayList<PhotoWallListView.PhotoPath> paramArrayList)
  {
    this.d = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.PhotoWallListView
 * JD-Core Version:    0.7.0.1
 */