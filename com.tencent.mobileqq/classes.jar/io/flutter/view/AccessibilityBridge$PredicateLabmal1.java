package io.flutter.view;

import io.flutter.util.Predicate;

class AccessibilityBridge$PredicateLabmal1
  implements Predicate<AccessibilityBridge.SemanticsNode>
{
  private AccessibilityBridge.SemanticsNode facusedSemanticsNode;
  
  public AccessibilityBridge$PredicateLabmal1(AccessibilityBridge paramAccessibilityBridge, AccessibilityBridge.SemanticsNode paramSemanticsNode)
  {
    this.facusedSemanticsNode = paramSemanticsNode;
  }
  
  public boolean test(AccessibilityBridge.SemanticsNode paramSemanticsNode)
  {
    return this.facusedSemanticsNode == paramSemanticsNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.PredicateLabmal1
 * JD-Core Version:    0.7.0.1
 */