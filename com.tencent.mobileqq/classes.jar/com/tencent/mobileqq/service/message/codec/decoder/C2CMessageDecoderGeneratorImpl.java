package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.imcore.message.basic.ClassGenerator;
import com.tencent.imcore.message.basic.ClassGeneratorImpl;
import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;
import java.util.List;

public class C2CMessageDecoderGeneratorImpl
  implements C2CMessageDecoderGenerator
{
  private ClassGenerator<Decoder> jdField_a_of_type_ComTencentImcoreMessageBasicClassGenerator = new ClassGeneratorImpl();
  private MapClassGenerator<Integer, Decoder> jdField_a_of_type_ComTencentImcoreMessageBasicMapClassGenerator = new MapClassGeneratorImpl();
  
  public Decoder a(Integer paramInteger)
  {
    return (Decoder)this.jdField_a_of_type_ComTencentImcoreMessageBasicMapClassGenerator.a(paramInteger);
  }
  
  public List<Decoder> a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageBasicClassGenerator.a();
  }
  
  public void a(Class<? extends Decoder> paramClass)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageBasicClassGenerator.a(paramClass);
  }
  
  public void a(Integer paramInteger, Class<? extends Decoder> paramClass)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageBasicMapClassGenerator.a(paramInteger, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */