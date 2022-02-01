package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class CenterProcessor
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Integer, AbsBaseProcessor> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public CenterProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new RobotProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new GameCardProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new LuckyCharacterProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(5), new TroopMgrAppProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new CenterProcessor.1(this));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new CenterProcessor.2(this));
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new CenterProcessor.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor
 * JD-Core Version:    0.7.0.1
 */