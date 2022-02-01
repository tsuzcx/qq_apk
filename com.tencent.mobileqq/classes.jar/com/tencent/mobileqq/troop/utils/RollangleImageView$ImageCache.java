package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedList;

public class RollangleImageView$ImageCache
{
  private static ImageCache jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  private Handler jdField_a_of_type_AndroidOsHandler = new RollangleImageView.ImageCache.2(this, BaseApplication.getContext().getMainLooper());
  private LinkedList<RollangleImageView.ImageCache.QueueItem> jdField_a_of_type_JavaUtilLinkedList;
  public boolean a;
  
  private RollangleImageView$ImageCache()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static ImageCache a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache == null) {
      jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache = new ImageCache();
    }
    return jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  }
  
  public Bitmap a(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      paramRollangleImageView = RollangleImageView.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopfileimage://");
      localStringBuilder.append(paramString);
      paramString = (Bitmap)paramRollangleImageView.get(localStringBuilder.toString());
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a()
  {
    try
    {
      LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
      if (localLinkedList == null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList = null;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally {}
  }
  
  public Bitmap b(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      Object localObject = RollangleImageView.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopfileimage://");
      localStringBuilder.append(paramString);
      localObject = (Bitmap)((MQLruCache)localObject).get(localStringBuilder.toString());
      if (localObject != null) {
        return localObject;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
        this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        ThreadManager.post(new RollangleImageView.ImageCache.1(this), 5, null, true);
      }
      localObject = new RollangleImageView.ImageCache.QueueItem();
      ((RollangleImageView.ImageCache.QueueItem)localObject).jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView = paramRollangleImageView;
      ((RollangleImageView.ImageCache.QueueItem)localObject).jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilLinkedList.add(localObject);
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache
 * JD-Core Version:    0.7.0.1
 */