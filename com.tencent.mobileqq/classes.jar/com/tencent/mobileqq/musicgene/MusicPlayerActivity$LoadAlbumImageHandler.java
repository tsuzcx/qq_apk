package com.tencent.mobileqq.musicgene;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MusicPlayerActivity$LoadAlbumImageHandler
  extends Handler
{
  private final WeakReference<MusicPlayerActivity> a;
  
  public MusicPlayerActivity$LoadAlbumImageHandler(MusicPlayerActivity paramMusicPlayerActivity)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramMusicPlayerActivity);
  }
  
  private void a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    MusicPlayerActivity localMusicPlayerActivity = (MusicPlayerActivity)this.a.get();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2) && (localMusicPlayerActivity != null))
    {
      int i = paramArrayOfInt[0];
      int j = Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, j, j, j, j, i });
      ((ImageView)localMusicPlayerActivity.findViewById(2131371635)).setImageDrawable(localGradientDrawable);
      localMusicPlayerActivity.findViewById(2131371638).setBackgroundColor(i);
      i = paramArrayOfInt[1];
      j = Color.argb(128, Color.red(i), Color.green(i), Color.blue(i));
      MusicPlayerActivity.a(localMusicPlayerActivity).setTextColor(i);
      MusicPlayerActivity.b(localMusicPlayerActivity).setTextColor(i);
      localMusicPlayerActivity.a.a().setLyricHilightColor(i);
      localMusicPlayerActivity.a.a().setLyricColor(j);
      MusicPlayerActivity.b(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.a(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.c(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130841862, i);
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130841863, i);
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130840090, i);
      if (paramBoolean)
      {
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130841369, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130841371, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130841370, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130837602, i);
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (MusicPlayerActivity)this.a.get();
    Object localObject2 = paramMessage.getData();
    if (localObject1 != null)
    {
      int j = paramMessage.what;
      int i = 4;
      switch (j)
      {
      default: 
      case 55: 
        localObject1 = MusicPlayerActivity.d((MusicPlayerActivity)localObject1).getTag();
        if ((localObject1 instanceof MusicPlayerActivity.ShareInfo))
        {
          localObject1 = (MusicPlayerActivity.ShareInfo)localObject1;
          if ((paramMessage.obj instanceof Bitmap))
          {
            localObject2 = (Bitmap)paramMessage.obj;
            long l = System.currentTimeMillis();
            if (paramMessage.arg1 == 2) {
              i = 0;
            } else {
              i = 1;
            }
            WXShareHelper.a().a(String.valueOf(l), ((MusicPlayerActivity.ShareInfo)localObject1).a, (Bitmap)localObject2, ((MusicPlayerActivity.ShareInfo)localObject1).b, ((MusicPlayerActivity.ShareInfo)localObject1).d, i, ((MusicPlayerActivity.ShareInfo)localObject1).e);
            return;
          }
        }
        break;
      case 54: 
        if ((paramMessage.obj instanceof View))
        {
          localObject2 = (View)paramMessage.obj;
          paramMessage = CalloutPopupWindow.a((Context)localObject1).b(3).a(((MusicPlayerActivity)localObject1).getString(paramMessage.arg1)).a(paramMessage.arg2);
          paramMessage.c(49);
          paramMessage = new CalloutPopupWindow.DrawableBuilder(paramMessage).b(Color.argb(13, 255, 255, 255)).a(5).a();
          if (paramMessage != null)
          {
            paramMessage = paramMessage.a();
            if (paramMessage != null)
            {
              paramMessage.a((View)localObject2);
              return;
            }
          }
        }
        break;
      case 53: 
        MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
        return;
      case 52: 
        if (localObject2 != null)
        {
          paramMessage = ((Bundle)localObject2).getString("KEY_SONG_NAME");
          ((Bundle)localObject2).getString("KEY_SINGER_NAME");
          Object localObject3 = ((Bundle)localObject2).getString("KEY_IMG_URL");
          boolean bool1 = ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG");
          boolean bool2 = ((Bundle)localObject2).getBoolean("KEY_IS_FAVOURITE");
          if (!TextUtils.isEmpty(paramMessage)) {
            MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setText(paramMessage);
          }
          if (bool1)
          {
            if (bool2) {
              MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130841370);
            } else {
              MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130841371);
            }
            MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setSelected(bool2);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (Patterns.WEB_URL.matcher((CharSequence)localObject3).matches()))
          {
            paramMessage = (URLImageView)((MusicPlayerActivity)localObject1).findViewById(2131371644);
            URLDrawable localURLDrawable = URLDrawable.getDrawable((String)localObject3, URLDrawable.URLDrawableOptions.obtain());
            Object localObject4 = AlbumDecodeHandler.a((String)localObject3);
            if (localObject4 != null)
            {
              localObject3 = new int[((List)localObject4).size()];
              i = 0;
              while (i < ((List)localObject4).size())
              {
                localObject3[i] = ((Integer)((List)localObject4).get(i)).intValue();
                i += 1;
              }
              a((int[])localObject3, bool1);
            }
            else
            {
              localObject3 = new AlbumDecodeHandler((String)localObject3, MusicPlayerActivity.a((MusicPlayerActivity)localObject1), Boolean.valueOf(bool1));
              if (localURLDrawable.getStatus() == 1)
              {
                localObject4 = localURLDrawable.getCurrDrawable();
                if ((localObject4 instanceof RegionDrawable)) {
                  ((AlbumDecodeHandler)localObject3).run(null, ((RegionDrawable)localObject4).getBitmap());
                }
              }
              else
              {
                localURLDrawable.setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
              }
            }
            paramMessage.setImageDrawable(localURLDrawable);
          }
          paramMessage = ((Bundle)localObject2).getString("KEY_SOURCE_NAME");
          if (TextUtils.isEmpty(paramMessage))
          {
            MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(2131694370);
            return;
          }
          MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(((MusicPlayerActivity)localObject1).getString(2131694368, new Object[] { paramMessage }));
          return;
        }
        break;
      case 51: 
        if ((paramMessage.obj instanceof MusicPlayerActivity.ShareInfo))
        {
          localObject2 = (MusicPlayerActivity.ShareInfo)paramMessage.obj;
          if (paramMessage.arg1 == 1) {
            i = 0;
          }
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setVisibility(i);
          if (MusicPlayerActivity.a((MusicPlayerActivity)localObject1).isSelected()) {
            MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130841370);
          } else {
            MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130841371);
          }
          MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setVisibility(i);
          MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setImageResource(2130841369);
          MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setVisibility(i);
          MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setImageResource(2130837602);
          MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setTag(localObject2);
          return;
        }
        break;
      case 50: 
        i = paramMessage.arg1;
        paramMessage = MusicPlayerActivity.b((MusicPlayerActivity)localObject1).getTag();
        if ((paramMessage instanceof Integer))
        {
          j = ((Integer)paramMessage).intValue();
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130841862, j);
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130841863, j);
        }
        if ((i != 3) && (i != 4)) {
          MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130841862);
        } else {
          MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130841863);
        }
        MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
        return;
      case 49: 
        a(((Bundle)localObject2).getIntArray("KEY_COLOR_LIST"), ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.LoadAlbumImageHandler
 * JD-Core Version:    0.7.0.1
 */