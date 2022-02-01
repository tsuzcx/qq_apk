package com.tencent.mobileqq.search.searchengine;

import ajdx;
import android.os.Bundle;
import bcfq;
import bchm;
import bcho;
import bcmc;
import bcmd;
import bcmh;
import bcmi;
import bcmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetSearchEngine
  implements bcmc<bcfq>
{
  public static double a;
  public static double b;
  private int jdField_a_of_type_Int = -1;
  ajdx jdField_a_of_type_Ajdx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NetSearchEngine.NetSearchRunnalbe jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe;
  private Future jdField_a_of_type_JavaUtilConcurrentFuture;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  
  public NetSearchEngine(QQAppInterface paramQQAppInterface, ThreadPoolExecutor paramThreadPoolExecutor, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = paramThreadPoolExecutor;
    this.jdField_a_of_type_Int = paramInt;
    if (paramThreadPoolExecutor == null) {
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    }
    SosoInterface.a(new bcmh(this, 0, true, false, 60000L, false, false, "SearchContacts"));
    this.jdField_a_of_type_Ajdx = new ajdx(paramQQAppInterface);
  }
  
  private int[] a(int paramInt)
  {
    if (paramInt < 0) {}
    ArrayList localArrayList;
    int i;
    do
    {
      return null;
      localArrayList = new ArrayList(5);
      if ((paramInt & 0x2) >= 1) {
        localArrayList.add(Integer.valueOf(80000000));
      }
      if ((paramInt & 0x4) >= 1) {
        localArrayList.add(Integer.valueOf(80000001));
      }
      if ((paramInt & 0x8) >= 1) {
        localArrayList.add(Integer.valueOf(80000002));
      }
      if ((paramInt & 0x10) >= 1) {
        localArrayList.add(Integer.valueOf(80000003));
      }
      i = localArrayList.size();
    } while (i <= 0);
    int[] arrayOfInt = new int[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt[paramInt] = ((Integer)localArrayList.get(paramInt)).intValue();
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public List<bcfq> a(bcmq parambcmq)
  {
    Object localObject = parambcmq.jdField_a_of_type_AndroidOsBundle;
    int i = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
    int j = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    int[] arrayOfInt = a(i);
    if (arrayOfInt == null) {
      return null;
    }
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe = new NetSearchEngine.NetSearchRunnalbe(this, parambcmq.jdField_a_of_type_JavaLangString, arrayOfInt, j, new bcmi(this, (List)localObject));
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe.a.await();
      return localObject;
    }
    catch (InterruptedException parambcmq)
    {
      for (;;)
      {
        parambcmq.printStackTrace();
      }
    }
  }
  
  List<bcfq> a(String paramString, int paramInt, SummaryCardBusiEntry.comm paramcomm, byte[] paramArrayOfByte)
  {
    bchm localbchm = bcho.a(paramInt);
    if (localbchm != null) {
      return localbchm.a(new Object[] { paramcomm, paramArrayOfByte, paramString });
    }
    return null;
  }
  
  public void a() {}
  
  public void a(bcmq parambcmq, bcmd<bcfq> parambcmd)
  {
    Object localObject = parambcmq.jdField_a_of_type_AndroidOsBundle;
    int i = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
    int j = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    localObject = a(i);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe = new NetSearchEngine.NetSearchRunnalbe(this, parambcmq.jdField_a_of_type_JavaLangString, (int[])localObject, j, parambcmd);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentFuture != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
      if ((this.jdField_a_of_type_JavaUtilConcurrentFuture instanceof Runnable)) {
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.remove((Runnable)this.jdField_a_of_type_JavaUtilConcurrentFuture);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe.a();
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine
 * JD-Core Version:    0.7.0.1
 */