package com.tencent.mobileqq.troop.widget;

import ajzl;
import ajzn;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class AvatarWallViewPagerAdapter
  extends PagerAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public Bitmap a;
  public Handler a;
  protected View a;
  public QQAppInterface a;
  public TroopAvatarManger a;
  protected AvatarWallViewPager a;
  public FaceDecoder a;
  public String a;
  protected List a;
  public WeakReference a;
  public boolean a;
  public int b;
  protected Handler b;
  protected View b;
  protected String b;
  protected boolean b;
  protected boolean c;
  
  public AvatarWallViewPagerAdapter(WeakReference paramWeakReference, AvatarWallViewPager paramAvatarWallViewPager, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, Handler paramHandler, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = paramAvatarWallViewPager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramBoolean;
    if ((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarWallViewPagerAdapter", 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder((Activity)paramWeakReference.get(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    paramWeakReference = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_JavaLangString, TroopUploadingTask.class, paramWeakReference);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public URLDrawable a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject1;
    }
    do
    {
      return paramString;
      localObject1 = localObject2;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = localObject2;
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
        localObject1 = localObject2;
        localURLDrawableOptions.mPlayGifImage = true;
        localObject1 = localObject2;
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
        localObject1 = localObject2;
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
        localObject1 = localObject2;
        paramString = URLDrawable.getDrawable(NearbyImgDownloader.a(AvatarTroopUtil.b(paramString)), localURLDrawableOptions);
        localObject1 = paramString;
        paramString.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0));
        localObject1 = paramString;
        paramString.setDecodeHandler(URLDrawableDecodeHandler.c);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString = (String)localObject1;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AvatarWallViewPagerAdapter", 2, "头像墙图片加载失败，URL格式错误");
    return localObject1;
  }
  
  public AvatarWallAdapter.AvatarInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  protected void a(AvatarWallViewPagerAdapter.ViewHolder paramViewHolder, int paramInt, String paramString, AvatarWallAdapter.AvatarInfo paramAvatarInfo)
  {
    paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
    if (paramInt == 0) {
      if (paramString != null)
      {
        paramString = a(paramString);
        if (paramString == null) {
          break label29;
        }
        paramViewHolder.setImageDrawable(paramString);
      }
    }
    label28:
    label29:
    do
    {
      do
      {
        do
        {
          break label28;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.e("AvatarWallViewPagerAdapter", 2, "avatar wall pic load error，createUrlDrawableByPath return null");
          return;
          if (paramInt != 2) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AvatarWallViewPagerAdapter", 2, "viewFactory: AVATAR_LOCAL, path=" + paramString);
          }
        } while ((paramString == null) || (paramAvatarInfo == null));
        try
        {
          if (paramAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            break;
          }
          ThreadManager.post(new ajzl(this, paramString, paramAvatarInfo, paramViewHolder), 8, null, true);
          return;
        }
        catch (OutOfMemoryError paramViewHolder) {}
      } while (!QLog.isColorLevel());
      QLog.d("AvatarWallViewPagerAdapter", 2, paramViewHolder.getMessage());
      return;
      if (!paramAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        paramViewHolder.setImageBitmap(paramAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
      }
      paramViewHolder.setImageDrawable(null);
      return;
    } while (paramInt != 3);
    ThreadManager.post(new ajzn(this, paramViewHolder, paramString), 8, null, true);
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool3;
      if (QLog.isColorLevel())
      {
        QLog.d("AvatarWallViewPagerAdapter", 2, "the adapter of AvatarWallViewPager is destroyed ...");
        bool1 = bool3;
      }
    }
    label80:
    do
    {
      return bool1;
      localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 14;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if ((paramList != null) && (paramList.size() != 0)) {
        break label190;
      }
      i = 1;
      if (i == 0) {
        break;
      }
      bool1 = bool3;
    } while (!paramBoolean);
    Object localObject = new AvatarWallAdapter.AvatarInfo();
    ((AvatarWallAdapter.AvatarInfo)localObject).d = "SYSTEM_PHOTO";
    ((AvatarWallAdapter.AvatarInfo)localObject).c = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
    paramList = new ArrayList();
    paramList.add(localObject);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (paramBoolean = true;; paramBoolean = true)
    {
      bool1 = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_b_of_type_AndroidViewView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.b();
      return paramBoolean;
      label190:
      i = 0;
      break label80;
      if (this.jdField_a_of_type_JavaUtilList.size() == paramList.size()) {
        break label218;
      }
    }
    label218:
    int i = 0;
    for (;;)
    {
      paramBoolean = bool2;
      if (i >= paramList.size()) {
        break;
      }
      localObject = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)paramList.get(i);
      if ((!((AvatarWallAdapter.AvatarInfo)localObject).c.equals(localAvatarInfo.c)) || (!((AvatarWallAdapter.AvatarInfo)localObject).d.equals(localAvatarInfo.d)) || (((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_Boolean != localAvatarInfo.jdField_b_of_type_Boolean))
      {
        paramBoolean = true;
        break;
      }
      i += 1;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = a();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (View)paramObject;
    int i = paramObject.getId();
    if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -2;
    }
    if (paramObject.getTag() == null) {
      return -2;
    }
    paramObject = (AvatarWallAdapter.AvatarInfo)paramObject.getTag();
    AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if ((!paramObject.c.equals(localAvatarInfo.c)) || (!paramObject.d.equals(localAvatarInfo.d)) || (paramObject.jdField_b_of_type_Boolean != localAvatarInfo.jdField_b_of_type_Boolean)) {
      return -2;
    }
    return -1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int k = 2;
    Object localObject = null;
    int i = a();
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "instantiateItem activity is null or data list count is 0");
      }
      return null;
    }
    if (i > 1) {
      if (paramInt == 1)
      {
        if (paramViewGroup == null)
        {
          if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() == null)) {
            return this.jdField_a_of_type_AndroidViewView;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() != null)) {
            this.jdField_a_of_type_AndroidViewView = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
          return this.jdField_a_of_type_AndroidViewView;
        }
      }
      else if (paramInt == i) {
        if (paramViewGroup == null)
        {
          if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getParent() == null)) {
            return this.jdField_b_of_type_AndroidViewView;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView.getParent() != null)) {
            this.jdField_b_of_type_AndroidViewView = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView);
          return this.jdField_b_of_type_AndroidViewView;
        }
      }
    }
    if (i > 1) {
      if (paramInt == 0) {
        i -= 1;
      }
    }
    for (;;)
    {
      View localView = LayoutInflater.from((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).inflate(2130969428, null);
      AvatarWallViewPagerAdapter.ViewHolder localViewHolder = new AvatarWallViewPagerAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362772));
      if (a() <= i) {}
      for (int j = 0;; j = i)
      {
        AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        String str;
        if (localAvatarInfo != null)
        {
          str = localAvatarInfo.d;
          if ((!str.equals("AVATAR_URL_STR")) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists()))) {
            break label520;
          }
          localObject = AvatarTroopUtil.a(localAvatarInfo.c, this.jdField_a_of_type_JavaLangString, 1);
          i = 0;
        }
        for (;;)
        {
          label356:
          if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
            localView.setContentDescription(((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131430218));
          }
          a(localViewHolder, i, (String)localObject, localAvatarInfo);
          if (localAvatarInfo.jdField_b_of_type_Boolean)
          {
            if (localViewHolder.jdField_a_of_type_AndroidViewView == null)
            {
              localViewHolder.jdField_a_of_type_AndroidViewView = ((ViewStub)localView.findViewById(2131366464)).inflate();
              localObject = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).height = -1;
              ((FrameLayout.LayoutParams)localObject).width = -1;
              localViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
            label474:
            localView.setTag(localAvatarInfo);
            localView.setId(j);
            if (paramViewGroup == null) {
              break label622;
            }
            paramViewGroup.addView(localView);
          }
          for (;;)
          {
            return localView;
            if (paramInt == i + 1)
            {
              i = 0;
              break;
            }
            i = paramInt - 1;
            break;
            label520:
            if ((str.equals("AVATAR_LOCAL_STR")) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
            {
              localObject = localAvatarInfo.jdField_b_of_type_JavaLangString;
              i = k;
              break label356;
            }
            if (!str.equals("SYSTEM_PHOTO")) {
              break label662;
            }
            localObject = AvatarTroopUtil.a(localAvatarInfo.c, this.jdField_a_of_type_JavaLangString, 0);
            i = 3;
            break label356;
            if (localViewHolder.jdField_a_of_type_AndroidViewView == null) {
              break label474;
            }
            localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
            break label474;
            label622:
            i = getCount();
            if (i > 1) {
              if (paramInt == 1) {
                this.jdField_a_of_type_AndroidViewView = localView;
              } else if (paramInt == i - 2) {
                this.jdField_b_of_type_AndroidViewView = localView;
              }
            }
          }
          label662:
          i = -1;
        }
      }
      i = 0;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */