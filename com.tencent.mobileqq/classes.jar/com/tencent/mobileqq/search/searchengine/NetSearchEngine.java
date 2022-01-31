package com.tencent.mobileqq.search.searchengine;

import aiav;
import aiaw;
import aiax;
import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.search.net.parser.INetSearchResultParser;
import com.tencent.mobileqq.search.net.parser.ParserFactory;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetSearchEngine
  implements ISearchEngine
{
  public static double a;
  public static double b;
  private int jdField_a_of_type_Int = -1;
  private aiax jdField_a_of_type_Aiax;
  public ContactSearchFacade a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    SosoInterface.a(new aiav(this, 0, true, false, 60000L, false, false, "SearchContacts"));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(paramQQAppInterface);
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
  
  public List a(SearchRequest paramSearchRequest)
  {
    Object localObject = paramSearchRequest.jdField_a_of_type_AndroidOsBundle;
    int i = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
    int j = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    int[] arrayOfInt = a(i);
    if (arrayOfInt == null) {
      return null;
    }
    localObject = new ArrayList();
    this.jdField_a_of_type_Aiax = new aiax(this, paramSearchRequest.jdField_a_of_type_JavaLangString, arrayOfInt, j, new aiaw(this, (List)localObject));
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_Aiax);
    try
    {
      this.jdField_a_of_type_Aiax.a.await();
      return localObject;
    }
    catch (InterruptedException paramSearchRequest)
    {
      for (;;)
      {
        paramSearchRequest.printStackTrace();
      }
    }
  }
  
  public List a(String paramString, int paramInt, SummaryCardBusiEntry.comm paramcomm, byte[] paramArrayOfByte)
  {
    INetSearchResultParser localINetSearchResultParser = ParserFactory.a(paramInt);
    if (localINetSearchResultParser != null) {
      return localINetSearchResultParser.a(new Object[] { paramcomm, paramArrayOfByte, paramString });
    }
    return null;
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    Object localObject = paramSearchRequest.jdField_a_of_type_AndroidOsBundle;
    int i = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
    int j = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    localObject = a(i);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_Aiax = new aiax(this, paramSearchRequest.jdField_a_of_type_JavaLangString, (int[])localObject, j, paramISearchListener);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_Aiax);
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
    if (this.jdField_a_of_type_Aiax != null) {
      this.jdField_a_of_type_Aiax.a();
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine
 * JD-Core Version:    0.7.0.1
 */