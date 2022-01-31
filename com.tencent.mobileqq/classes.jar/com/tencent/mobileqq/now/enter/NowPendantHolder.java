package com.tencent.mobileqq.now.enter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NowPendantHolder
  extends ConversationActivePendantHolderBase
  implements NowEnterManager.DownloadListener
{
  private Resources a;
  protected Drawable a;
  protected String a;
  public boolean b;
  protected boolean c;
  
  public NowPendantHolder(View paramView)
  {
    super(paramView);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839540);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.postInvalidate();
      }
      if (QLog.isColorLevel()) {
        QLog.d("now_enter.pendant.NowPendantHolder", 2, "loadLocalDrawable isUseLocalDrawable=true");
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("now_enter.pendant.NowPendantHolder", 1, "[loadLocalDrawable] oom=", localOutOfMemoryError);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("now_enter.pendant.NowPendantHolder", 1, "[loadLocalDrawable] exception=", localException);
    }
  }
  
  public void a()
  {
    int i = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 112.5F);
    int j = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 71.5F);
    int k = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 45.0F);
    int m = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 6.0F);
    int n = (int)DeviceInfoUtil.j();
    if (QLog.isColorLevel()) {
      QLog.d("now_enter.pendant.NowPendantHolder", 2, "initPendantParams: w=" + j + ", h=" + i + ", vw=" + n);
    }
    g();
    a(n - j - k, -m, j, i, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  protected void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
  }
  
  protected void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("now_enter.pendant.NowPendantHolder", 2, "loadServerDrawable, url=" + paramString);
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = NowEnterManager.a(localQQAppInterface, paramString);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("now_enter.pendant.NowPendantHolder", 2, "loadServerDrawable, use server Drawable");
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, (Bitmap)localObject);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = paramString;
        if (this.jdField_a_of_type_AndroidViewView == null) {
          return;
        }
        this.jdField_a_of_type_AndroidViewView.postInvalidate();
      }
    }
    catch (OutOfMemoryError paramString)
    {
      QQAppInterface localQQAppInterface;
      QLog.e("now_enter.pendant.NowPendantHolder", 1, "[loadServerDrawable] oom=", paramString);
      return;
      Object localObject = (NowEnterManager)localQQAppInterface.getManager(264);
      ((NowEnterManager)localObject).a(this);
      ((NowEnterManager)localObject).a(localQQAppInterface, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("now_enter.pendant.NowPendantHolder", 1, "[loadServerDrawable] exception=", paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      try
      {
        Bitmap localBitmap = NowEnterManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString);
        if (localBitmap != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("now_enter.pendant.NowPendantHolder", 2, "onDownloaded, use server Drawable");
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, localBitmap);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_JavaLangString = paramString;
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.postInvalidate();
          }
        }
        else
        {
          QLog.w("now_enter.pendant.NowPendantHolder", 1, "[onDownloaded] getBitmap==null after onDownload succ");
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("now_enter.pendant.NowPendantHolder", 1, "[onDownloaded] oom=", paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("now_enter.pendant.NowPendantHolder", 1, "[onDownloaded] exception=", paramString);
      }
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool = false;
    d();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    a(paramCanvas);
    int j;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (this.j != 0)
      {
        paramCanvas.save();
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramCanvas.translate(this.f, this.g);
        if (localObject != null)
        {
          ((Drawable)localObject).setAlpha(this.j);
          ((Drawable)localObject).setBounds(0, 0, this.h, this.i);
        }
        paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.h / 2, this.i / 2);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
      }
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      j = i;
      if (((Iterator)localObject).hasNext())
      {
        Animation localAnimation = (Animation)((Iterator)localObject).next();
        if ((i != 0) || (localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation))) {}
        for (i = 1;; i = 0) {
          break;
        }
      }
    }
    else
    {
      j = 0;
    }
    b(paramCanvas);
    paramCanvas.restore();
    if ((this.jdField_a_of_type_Boolean) || (j != 0)) {
      bool = true;
    }
    return bool;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  protected void b(Canvas paramCanvas)
  {
    super.b(paramCanvas);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void f()
  {
    String str = ((NowEnterManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(264)).b();
    if (QLog.isColorLevel()) {
      QLog.d("now_enter.pendant.NowPendantHolder", 2, "checkUpdateDrawable, isUseLocal=" + this.jdField_c_of_type_Boolean + ", serverUrl=" + str + ", showUrl=" + this.jdField_a_of_type_JavaLangString);
    }
    if ((!this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(str))) {
      g();
    }
    do
    {
      return;
      if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(str)) && (!str.equals(this.jdField_a_of_type_JavaLangString)))
      {
        a(str);
        return;
      }
    } while ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(str)));
    a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowPendantHolder
 * JD-Core Version:    0.7.0.1
 */