package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.Extension;
import com.google.protobuf.nano.FieldOptions;
import com.google.protobuf.nano.MessageOptions;
import com.google.protobuf.nano.OneofOptions;

public abstract interface Validate
{
  public static final Extension<MessageOptions, Boolean> a = Extension.createPrimitiveTyped(8, Boolean.class, 8568L);
  public static final Extension<OneofOptions, Boolean> b = Extension.createPrimitiveTyped(8, Boolean.class, 8568L);
  public static final Extension<FieldOptions, FieldRules> c = Extension.createMessageTyped(11, FieldRules.class, 8570L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.Validate
 * JD-Core Version:    0.7.0.1
 */