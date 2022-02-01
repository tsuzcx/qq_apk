package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.imcore.message.basic.ClassGenerator;
import com.tencent.imcore.message.basic.ClassGeneratorImpl;
import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;
import java.util.List;

public class C2CMessageDecoderGeneratorImpl
  implements C2CMessageDecoderGenerator
{
  private MapClassGenerator<Integer, Decoder> a = new MapClassGeneratorImpl();
  private ClassGenerator<Decoder> b = new ClassGeneratorImpl();
  
  public Decoder a(Integer paramInteger)
  {
    return (Decoder)this.a.a(paramInteger);
  }
  
  public List<Decoder> a()
  {
    return this.b.a();
  }
  
  public void a(Class<? extends Decoder> paramClass)
  {
    this.b.a(paramClass);
  }
  
  public void a(Integer paramInteger, Class<? extends Decoder> paramClass)
  {
    this.a.a(paramInteger, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */