package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExtendFriendHonorOfKingRecordView
  extends FrameLayout
{
  private View a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private URLImageView l;
  private URLImageView m;
  private URLImageView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  
  public ExtendFriendHonorOfKingRecordView(@NonNull @NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ExtendFriendHonorOfKingRecordView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ExtendFriendHonorOfKingRecordView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext).inflate(1912995844, this, true);
    this.b = ((ImageView)this.a.findViewById(1912930403));
    this.d = ((ImageView)this.a.findViewById(1912930429));
    this.c = ((ImageView)this.a.findViewById(1912930406));
    this.e = ((TextView)this.a.findViewById(1912930430));
    this.f = ((TextView)this.a.findViewById(1912930407));
    this.g = ((ImageView)this.a.findViewById(1912930405));
    this.h = ((TextView)this.a.findViewById(1912930442));
    this.i = ((TextView)this.a.findViewById(1912930385));
    this.j = ((TextView)this.a.findViewById(1912930463));
    this.k = ((TextView)this.a.findViewById(1912930356));
    this.l = ((URLImageView)this.a.findViewById(1912930414));
    this.m = ((URLImageView)this.a.findViewById(1912930415));
    this.n = ((URLImageView)this.a.findViewById(1912930416));
    this.o = ((ImageView)this.a.findViewById(1912930417));
    this.p = ((ImageView)this.a.findViewById(1912930418));
    this.q = ((ImageView)this.a.findViewById(1912930419));
  }
  
  private void setGameInfo(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.optInt("games_total", 0);
    this.h.setText(String.valueOf(i1));
    i1 = paramJSONObject.optInt("mvp_total", 0);
    this.i.setText(String.valueOf(i1));
    try
    {
      double d1 = paramJSONObject.optDouble("win_rate");
      Object localObject = NumberFormat.getPercentInstance();
      ((NumberFormat)localObject).setMaximumFractionDigits(2);
      localObject = ((NumberFormat)localObject).format(d1);
      this.j.setText((CharSequence)localObject);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    i1 = paramJSONObject.optInt("best_occupation", 0);
    paramJSONObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getOccupationTypeText(i1);
    if (!TextUtils.isEmpty(paramJSONObject)) {
      this.k.setText(paramJSONObject);
    }
  }
  
  private void setGrade(int paramInt)
  {
    int i1 = paramInt / 100000;
    Object localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeStarImagePathById(paramInt);
    localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject);
    if (i1 >= 8)
    {
      if (localObject != null) {
        this.d.setImageBitmap((Bitmap)localObject);
      }
      localObject = getContext().getString(2131890879, new Object[] { String.valueOf(paramInt % 10000) });
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.e.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (localObject != null) {
        this.c.setImageBitmap((Bitmap)localObject);
      }
      localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeNumberIconPathById(paramInt);
      localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject);
      if (localObject != null) {
        this.g.setImageBitmap((Bitmap)localObject);
      }
    }
    localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeIconPathById(paramInt);
    localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject);
    if (localObject != null) {
      this.b.setImageBitmap((Bitmap)localObject);
    }
    localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGradeDescById(paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.f.setText((CharSequence)localObject);
    }
  }
  
  private void setHeroIcons(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("best_heros");
    int i1;
    if (paramJSONObject == null) {
      i1 = 0;
    } else {
      i1 = paramJSONObject.length();
    }
    ArrayList localArrayList1 = new ArrayList(3);
    localArrayList1.add(this.l);
    localArrayList1.add(this.m);
    localArrayList1.add(this.n);
    ArrayList localArrayList2 = new ArrayList(3);
    localArrayList2.add(this.o);
    localArrayList2.add(this.p);
    localArrayList2.add(this.q);
    int i2 = 0;
    while (i2 < 3)
    {
      if (i2 >= i1)
      {
        ((URLImageView)localArrayList1.get(i2)).setVisibility(8);
        ((ImageView)localArrayList2.get(i2)).setVisibility(8);
      }
      else
      {
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.dpToPx(20.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.dpToPx(20.0F);
        Object localObject1 = paramJSONObject.optJSONObject(i2);
        if (localObject1 == null)
        {
          ((URLImageView)localArrayList1.get(i2)).setVisibility(8);
          ((ImageView)localArrayList2.get(i2)).setVisibility(8);
        }
        else
        {
          localObject2 = URLDrawable.getDrawable(((JSONObject)localObject1).optString("icon"), (URLDrawable.URLDrawableOptions)localObject2);
          if (localObject2 != null)
          {
            i3 = ViewUtils.dpToPx(20.0F);
            ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(i3, i3));
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.o);
            ((URLImageView)localArrayList1.get(i2)).setImageDrawable((Drawable)localObject2);
          }
          ((URLImageView)localArrayList1.get(i2)).setVisibility(0);
          int i3 = ((JSONObject)localObject1).optInt("skill", 0);
          localObject1 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameSkilledLevelIconPath(i3);
          localObject1 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject1);
          if (localObject1 != null)
          {
            ((ImageView)localArrayList2.get(i2)).setImageBitmap((Bitmap)localObject1);
            ((ImageView)localArrayList2.get(i2)).setVisibility(0);
          }
        }
      }
      i2 += 1;
    }
  }
  
  public void setData(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONObject("record");
    if (paramJSONObject == null) {
      return;
    }
    setGrade(paramJSONObject.optInt("grade", 0));
    setGameInfo(paramJSONObject);
    setHeroIcons(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendHonorOfKingRecordView
 * JD-Core Version:    0.7.0.1
 */